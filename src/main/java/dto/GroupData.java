package dto;

import java.util.*;

public class GroupData {
    private final String name;
    private final String header;
    private final String footer;
    private Integer id;

    public GroupData(String name, String header, String footer, Integer id) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = id;
    }

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name) && Objects.equals(id, groupData.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
