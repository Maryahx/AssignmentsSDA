package pojos;

public class PetStoreCategoryPojo {
    private Integer categoryId;
    private String categoryName;

    public PetStoreCategoryPojo() {
    }

    public PetStoreCategoryPojo(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "PetStoreCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

/*
  "category": {
         "id": 0,
         "name": "string"
 }
 */