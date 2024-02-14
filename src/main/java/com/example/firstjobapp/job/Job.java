package com.example.firstjobapp.job;

public class Job {

    // ---------- Attributes ----------------
    private Long id;
    private String title;
    private String description;
    private Long minSalary;
    private Long maxSalary;
    private String location;

    // ---------- Constructor ----------------
    public Job(Long id, String title, String description, Long minSalary, Long maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }


    // ---------- Getters / Setters ----------------
    public Long getId() {
        return (long) id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean updateFrom(Job other){
        //Assumption: The id of other job should match this one. Else fail.
        if ( this.id.equals(other.getId()) ) {
            //update only if other.field not null.
            if (other.getTitle() != null)
                this.title = other.getTitle();
            if (other.getDescription() != null)
                this.description = other.getDescription();
            if (other.getMinSalary() != null)
                this.minSalary = other.getMinSalary();
            if (other.getMaxSalary() != null)
                this.maxSalary = other.getMaxSalary();
            if (other.getLocation() != null)
                this.location = other.getLocation();
            return true;
        }
        else
            return false;
    }
}
