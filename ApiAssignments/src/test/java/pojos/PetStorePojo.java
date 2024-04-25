package pojos;

import java.util.List;

public class PetStorePojo {

    private Integer id;
    private PetStoreCategoryPojo category;
    private String name;
    private List<String> photoUrls;
    private List<PetStoreTagsPojo> tags;
    private String status;

    public PetStorePojo() {
    }

    public PetStorePojo(Integer id, PetStoreCategoryPojo category, String name, List<String> photoUrls, List<PetStoreTagsPojo> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PetStoreCategoryPojo getCategory() {
        return category;
    }

    public void setCategory(PetStoreCategoryPojo category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<PetStoreTagsPojo> getTags() {
        return tags;
    }

    public void setTags(List<PetStoreTagsPojo> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetStorePojo{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}