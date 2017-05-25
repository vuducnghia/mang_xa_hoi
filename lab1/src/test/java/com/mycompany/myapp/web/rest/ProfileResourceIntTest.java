package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.Lab1App;

import com.mycompany.myapp.domain.Profile;
import com.mycompany.myapp.repository.ProfileRepository;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ProfileResource REST controller.
 *
 * @see ProfileResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Lab1App.class)
public class ProfileResourceIntTest {

    private static final String DEFAULT_TEN = "AAAAAAAAAA";
    private static final String UPDATED_TEN = "BBBBBBBBBB";

    private static final String DEFAULT_SDT = "AAAAAAAAAA";
    private static final String UPDATED_SDT = "BBBBBBBBBB";

    private static final String DEFAULT_DIACHI = "AAAAAAAAAA";
    private static final String UPDATED_DIACHI = "BBBBBBBBBB";

    private static final byte[] DEFAULT_ANHBIA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_ANHBIA = TestUtil.createByteArray(2, "1");
    private static final String DEFAULT_ANHBIA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_ANHBIA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_ANHDAIDIEN = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_ANHDAIDIEN = TestUtil.createByteArray(2, "1");
    private static final String DEFAULT_ANHDAIDIEN_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_ANHDAIDIEN_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_ANHCANHAN = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_ANHCANHAN = TestUtil.createByteArray(2, "1");
    private static final String DEFAULT_ANHCANHAN_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_ANHCANHAN_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_TIEUSU = "AAAAAAAAAA";
    private static final String UPDATED_TIEUSU = "BBBBBBBBBB";

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restProfileMockMvc;

    private Profile profile;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ProfileResource profileResource = new ProfileResource(profileRepository);
        this.restProfileMockMvc = MockMvcBuilders.standaloneSetup(profileResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Profile createEntity(EntityManager em) {
        Profile profile = new Profile()
            .ten(DEFAULT_TEN)
            .sdt(DEFAULT_SDT)
            .diachi(DEFAULT_DIACHI)
            .anhbia(DEFAULT_ANHBIA)
            .anhbiaContentType(DEFAULT_ANHBIA_CONTENT_TYPE)
            .anhdaidien(DEFAULT_ANHDAIDIEN)
            .anhdaidienContentType(DEFAULT_ANHDAIDIEN_CONTENT_TYPE)
            .anhcanhan(DEFAULT_ANHCANHAN)
            .anhcanhanContentType(DEFAULT_ANHCANHAN_CONTENT_TYPE)
            .tieusu(DEFAULT_TIEUSU);
        return profile;
    }

    @Before
    public void initTest() {
        profile = createEntity(em);
    }

    @Test
    @Transactional
    public void createProfile() throws Exception {
        int databaseSizeBeforeCreate = profileRepository.findAll().size();

        // Create the Profile
        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isCreated());

        // Validate the Profile in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeCreate + 1);
        Profile testProfile = profileList.get(profileList.size() - 1);
        assertThat(testProfile.getTen()).isEqualTo(DEFAULT_TEN);
        assertThat(testProfile.getSdt()).isEqualTo(DEFAULT_SDT);
        assertThat(testProfile.getDiachi()).isEqualTo(DEFAULT_DIACHI);
        assertThat(testProfile.getAnhbia()).isEqualTo(DEFAULT_ANHBIA);
        assertThat(testProfile.getAnhbiaContentType()).isEqualTo(DEFAULT_ANHBIA_CONTENT_TYPE);
        assertThat(testProfile.getAnhdaidien()).isEqualTo(DEFAULT_ANHDAIDIEN);
        assertThat(testProfile.getAnhdaidienContentType()).isEqualTo(DEFAULT_ANHDAIDIEN_CONTENT_TYPE);
        assertThat(testProfile.getAnhcanhan()).isEqualTo(DEFAULT_ANHCANHAN);
        assertThat(testProfile.getAnhcanhanContentType()).isEqualTo(DEFAULT_ANHCANHAN_CONTENT_TYPE);
        assertThat(testProfile.getTieusu()).isEqualTo(DEFAULT_TIEUSU);
    }

    @Test
    @Transactional
    public void createProfileWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = profileRepository.findAll().size();

        // Create the Profile with an existing ID
        profile.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkTenIsRequired() throws Exception {
        int databaseSizeBeforeTest = profileRepository.findAll().size();
        // set the field null
        profile.setTen(null);

        // Create the Profile, which fails.

        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSdtIsRequired() throws Exception {
        int databaseSizeBeforeTest = profileRepository.findAll().size();
        // set the field null
        profile.setSdt(null);

        // Create the Profile, which fails.

        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDiachiIsRequired() throws Exception {
        int databaseSizeBeforeTest = profileRepository.findAll().size();
        // set the field null
        profile.setDiachi(null);

        // Create the Profile, which fails.

        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAnhbiaIsRequired() throws Exception {
        int databaseSizeBeforeTest = profileRepository.findAll().size();
        // set the field null
        profile.setAnhbia(null);

        // Create the Profile, which fails.

        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAnhdaidienIsRequired() throws Exception {
        int databaseSizeBeforeTest = profileRepository.findAll().size();
        // set the field null
        profile.setAnhdaidien(null);

        // Create the Profile, which fails.

        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAnhcanhanIsRequired() throws Exception {
        int databaseSizeBeforeTest = profileRepository.findAll().size();
        // set the field null
        profile.setAnhcanhan(null);

        // Create the Profile, which fails.

        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProfiles() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);

        // Get all the profileList
        restProfileMockMvc.perform(get("/api/profiles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(profile.getId().intValue())))
            .andExpect(jsonPath("$.[*].ten").value(hasItem(DEFAULT_TEN.toString())))
            .andExpect(jsonPath("$.[*].sdt").value(hasItem(DEFAULT_SDT.toString())))
            .andExpect(jsonPath("$.[*].diachi").value(hasItem(DEFAULT_DIACHI.toString())))
            .andExpect(jsonPath("$.[*].anhbiaContentType").value(hasItem(DEFAULT_ANHBIA_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].anhbia").value(hasItem(Base64Utils.encodeToString(DEFAULT_ANHBIA))))
            .andExpect(jsonPath("$.[*].anhdaidienContentType").value(hasItem(DEFAULT_ANHDAIDIEN_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].anhdaidien").value(hasItem(Base64Utils.encodeToString(DEFAULT_ANHDAIDIEN))))
            .andExpect(jsonPath("$.[*].anhcanhanContentType").value(hasItem(DEFAULT_ANHCANHAN_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].anhcanhan").value(hasItem(Base64Utils.encodeToString(DEFAULT_ANHCANHAN))))
            .andExpect(jsonPath("$.[*].tieusu").value(hasItem(DEFAULT_TIEUSU.toString())));
    }

    @Test
    @Transactional
    public void getProfile() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);

        // Get the profile
        restProfileMockMvc.perform(get("/api/profiles/{id}", profile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(profile.getId().intValue()))
            .andExpect(jsonPath("$.ten").value(DEFAULT_TEN.toString()))
            .andExpect(jsonPath("$.sdt").value(DEFAULT_SDT.toString()))
            .andExpect(jsonPath("$.diachi").value(DEFAULT_DIACHI.toString()))
            .andExpect(jsonPath("$.anhbiaContentType").value(DEFAULT_ANHBIA_CONTENT_TYPE))
            .andExpect(jsonPath("$.anhbia").value(Base64Utils.encodeToString(DEFAULT_ANHBIA)))
            .andExpect(jsonPath("$.anhdaidienContentType").value(DEFAULT_ANHDAIDIEN_CONTENT_TYPE))
            .andExpect(jsonPath("$.anhdaidien").value(Base64Utils.encodeToString(DEFAULT_ANHDAIDIEN)))
            .andExpect(jsonPath("$.anhcanhanContentType").value(DEFAULT_ANHCANHAN_CONTENT_TYPE))
            .andExpect(jsonPath("$.anhcanhan").value(Base64Utils.encodeToString(DEFAULT_ANHCANHAN)))
            .andExpect(jsonPath("$.tieusu").value(DEFAULT_TIEUSU.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProfile() throws Exception {
        // Get the profile
        restProfileMockMvc.perform(get("/api/profiles/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProfile() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);
        int databaseSizeBeforeUpdate = profileRepository.findAll().size();

        // Update the profile
        Profile updatedProfile = profileRepository.findOne(profile.getId());
        updatedProfile
            .ten(UPDATED_TEN)
            .sdt(UPDATED_SDT)
            .diachi(UPDATED_DIACHI)
            .anhbia(UPDATED_ANHBIA)
            .anhbiaContentType(UPDATED_ANHBIA_CONTENT_TYPE)
            .anhdaidien(UPDATED_ANHDAIDIEN)
            .anhdaidienContentType(UPDATED_ANHDAIDIEN_CONTENT_TYPE)
            .anhcanhan(UPDATED_ANHCANHAN)
            .anhcanhanContentType(UPDATED_ANHCANHAN_CONTENT_TYPE)
            .tieusu(UPDATED_TIEUSU);

        restProfileMockMvc.perform(put("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedProfile)))
            .andExpect(status().isOk());

        // Validate the Profile in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeUpdate);
        Profile testProfile = profileList.get(profileList.size() - 1);
        assertThat(testProfile.getTen()).isEqualTo(UPDATED_TEN);
        assertThat(testProfile.getSdt()).isEqualTo(UPDATED_SDT);
        assertThat(testProfile.getDiachi()).isEqualTo(UPDATED_DIACHI);
        assertThat(testProfile.getAnhbia()).isEqualTo(UPDATED_ANHBIA);
        assertThat(testProfile.getAnhbiaContentType()).isEqualTo(UPDATED_ANHBIA_CONTENT_TYPE);
        assertThat(testProfile.getAnhdaidien()).isEqualTo(UPDATED_ANHDAIDIEN);
        assertThat(testProfile.getAnhdaidienContentType()).isEqualTo(UPDATED_ANHDAIDIEN_CONTENT_TYPE);
        assertThat(testProfile.getAnhcanhan()).isEqualTo(UPDATED_ANHCANHAN);
        assertThat(testProfile.getAnhcanhanContentType()).isEqualTo(UPDATED_ANHCANHAN_CONTENT_TYPE);
        assertThat(testProfile.getTieusu()).isEqualTo(UPDATED_TIEUSU);
    }

    @Test
    @Transactional
    public void updateNonExistingProfile() throws Exception {
        int databaseSizeBeforeUpdate = profileRepository.findAll().size();

        // Create the Profile

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restProfileMockMvc.perform(put("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isCreated());

        // Validate the Profile in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteProfile() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);
        int databaseSizeBeforeDelete = profileRepository.findAll().size();

        // Get the profile
        restProfileMockMvc.perform(delete("/api/profiles/{id}", profile.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Profile.class);
    }
}
