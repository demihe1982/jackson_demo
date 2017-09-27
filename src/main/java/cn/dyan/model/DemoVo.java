package cn.dyan.model;

public class DemoVo {

    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("name:");
        builder.append(this.getName());
        builder.append(" , desc:");
        builder.append(this.getDesc());
        return builder.toString();
    }
}
