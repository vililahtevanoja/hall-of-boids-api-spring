package fi.lahtevanoja.springtest.card;

import java.util.Date;

import fi.lahtevanoja.springtest.models.Project;

/**
 * Created on 2017-04-25.
 *
 * @author vili
 */
public class CardProject {
    private String client;
    private String description;
    private CardProjectDuration duration;
    private boolean current;

    CardProject() {
        this.client = "";
        this.description = "";
        this.duration = new CardProjectDuration(0, 0);
        this.current = false;
    }

    CardProject(Project project) {
        this.client = project.getClient();
        this.description = project.getDescription();
        this.duration = new CardProjectDuration(project.getDurationFrom(), project.getDurationTo());
        long now = new Date().getTime();
        this.current = (now > this.duration.getFrom()) && (now < this.duration.getTo());
    }

    CardProject(String client, String description, long durationFrom, long durationTo) {
        this.client = client;
        this.description = description;
        this.duration = new CardProjectDuration(durationFrom, durationTo);
        long now = new Date().getTime();
        this.current = (now > durationFrom) && (now < durationTo);
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardProjectDuration getDuration() {
        return duration;
    }

    public void setDuration(CardProjectDuration duration) {
        this.duration = duration;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
