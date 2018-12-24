package ilsiya.sabirzyanova.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "cat")
public class Cat implements Serializable {
    @Id
    @Type(type = "uuid-binary")
    @Column(name = "cat_id", length = 16)
    private UUID id = UUID.randomUUID();
    @Column(name = "cat_name")
    private String name;
    @Lob
    @Column(name = "cat_pict")
    private byte[] pict;
    @Column(name = "cat_rating")
    private int rating = 0;

    public Cat(Cat cat) {
        setId(cat.getId());
        setName(cat.getName());
        setPict(cat.getPict());
        setRating(cat.getRating());
    }

    public Cat() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPict(byte[] pict) {
        this.pict = pict;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getPict() {
        return pict;
    }

    public int getRating() {
        return rating;
    }
}
