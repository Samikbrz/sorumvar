package backend.sorumvar.model;

import javax.persistence.*;

@Entity
@Table(name = "IMAGE")
public class ImageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGEID")
    private long id;

    @Column(name = "PATH")
    private String path;

    @ManyToOne
    @JoinColumn(name = "QUESTIONID")
    private Question question;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


}
