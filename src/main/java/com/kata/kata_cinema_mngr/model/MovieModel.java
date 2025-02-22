package com.kata.kata_cinema_mngr.model;

public class MovieModel {

    private Long id;
    private String title;
    private String genre;
    private int running_Time;
    private String qualification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRunning_Time() {
        return running_Time;
    }

    public void setRunning_Time(int running_Time) {
        this.running_Time = running_Time;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
