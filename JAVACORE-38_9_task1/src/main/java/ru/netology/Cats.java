package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cats {

    private String id;
    private String text;
    private String type;
    private String user;
    private Integer upVotes;

    public Cats(@JsonProperty("id") String id,
                @JsonProperty("text") String text,
                @JsonProperty("type") String type,
                @JsonProperty("user") String user,
                @JsonProperty("upvotes") Integer upVotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upVotes = upVotes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    @Override
    public String toString() {
        return "Cats" +
                "\n id=" + id +
                "\n text=" + text +
                "\n type=" + type +
                "\n user=" + user +
                "\n upvotes=" + upVotes;
    }

}
