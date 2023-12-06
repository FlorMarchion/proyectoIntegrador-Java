package entities;

public  class ExpenseCategory {
    private Integer id;
    private String name;

    public ExpenseCategory() {
    }

    public ExpenseCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ExpenseCategory getId() {
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
        return "ExpenseCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
