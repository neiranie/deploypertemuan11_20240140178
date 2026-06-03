package c.d.pertemuan11.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nama;
    private String alamat;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}