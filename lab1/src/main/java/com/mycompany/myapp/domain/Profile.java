package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Profile.
 */
@Entity
@Table(name = "profile")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ten", nullable = false)
    private String ten;

    @NotNull
    @Column(name = "sdt", nullable = false)
    private String sdt;

    @NotNull
    @Column(name = "diachi", nullable = false)
    private String diachi;

    @NotNull
    @Lob
    @Column(name = "anhbia", nullable = false)
    private byte[] anhbia;

    @Column(name = "anhbia_content_type", nullable = false)
    private String anhbiaContentType;

    @NotNull
    @Lob
    @Column(name = "anhdaidien", nullable = false)
    private byte[] anhdaidien;

    @Column(name = "anhdaidien_content_type", nullable = false)
    private String anhdaidienContentType;

    @NotNull
    @Lob
    @Column(name = "anhcanhan", nullable = false)
    private byte[] anhcanhan;

    @Column(name = "anhcanhan_content_type", nullable = false)
    private String anhcanhanContentType;

    @Lob
    @Column(name = "tieusu")
    private String tieusu;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public Profile ten(String ten) {
        this.ten = ten;
        return this;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public Profile sdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public Profile diachi(String diachi) {
        this.diachi = diachi;
        return this;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public byte[] getAnhbia() {
        return anhbia;
    }

    public Profile anhbia(byte[] anhbia) {
        this.anhbia = anhbia;
        return this;
    }

    public void setAnhbia(byte[] anhbia) {
        this.anhbia = anhbia;
    }

    public String getAnhbiaContentType() {
        return anhbiaContentType;
    }

    public Profile anhbiaContentType(String anhbiaContentType) {
        this.anhbiaContentType = anhbiaContentType;
        return this;
    }

    public void setAnhbiaContentType(String anhbiaContentType) {
        this.anhbiaContentType = anhbiaContentType;
    }

    public byte[] getAnhdaidien() {
        return anhdaidien;
    }

    public Profile anhdaidien(byte[] anhdaidien) {
        this.anhdaidien = anhdaidien;
        return this;
    }

    public void setAnhdaidien(byte[] anhdaidien) {
        this.anhdaidien = anhdaidien;
    }

    public String getAnhdaidienContentType() {
        return anhdaidienContentType;
    }

    public Profile anhdaidienContentType(String anhdaidienContentType) {
        this.anhdaidienContentType = anhdaidienContentType;
        return this;
    }

    public void setAnhdaidienContentType(String anhdaidienContentType) {
        this.anhdaidienContentType = anhdaidienContentType;
    }

    public byte[] getAnhcanhan() {
        return anhcanhan;
    }

    public Profile anhcanhan(byte[] anhcanhan) {
        this.anhcanhan = anhcanhan;
        return this;
    }

    public void setAnhcanhan(byte[] anhcanhan) {
        this.anhcanhan = anhcanhan;
    }

    public String getAnhcanhanContentType() {
        return anhcanhanContentType;
    }

    public Profile anhcanhanContentType(String anhcanhanContentType) {
        this.anhcanhanContentType = anhcanhanContentType;
        return this;
    }

    public void setAnhcanhanContentType(String anhcanhanContentType) {
        this.anhcanhanContentType = anhcanhanContentType;
    }

    public String getTieusu() {
        return tieusu;
    }

    public Profile tieusu(String tieusu) {
        this.tieusu = tieusu;
        return this;
    }

    public void setTieusu(String tieusu) {
        this.tieusu = tieusu;
    }

    public User getUser() {
        return user;
    }

    public Profile user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        if (profile.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Profile{" +
            "id=" + id +
            ", ten='" + ten + "'" +
            ", sdt='" + sdt + "'" +
            ", diachi='" + diachi + "'" +
            ", anhbia='" + anhbia + "'" +
            ", anhbiaContentType='" + anhbiaContentType + "'" +
            ", anhdaidien='" + anhdaidien + "'" +
            ", anhdaidienContentType='" + anhdaidienContentType + "'" +
            ", anhcanhan='" + anhcanhan + "'" +
            ", anhcanhanContentType='" + anhcanhanContentType + "'" +
            ", tieusu='" + tieusu + "'" +
            '}';
    }
}
