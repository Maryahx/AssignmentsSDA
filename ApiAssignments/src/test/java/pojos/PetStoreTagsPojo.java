package pojos;

public class PetStoreTagsPojo {
    private Integer id;
    private String name;


    public PetStoreTagsPojo() {
    }

    public PetStoreTagsPojo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetStoreTagsPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}