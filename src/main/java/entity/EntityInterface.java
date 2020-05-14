package entity;

public interface EntityInterface {
    public <T extends BaseEntity> load(String target);
}
