//YApi QuickType插件生成，具体参考文档:https://github.com/RmondJone/YapiQuickType

package com.example.tvmazeapp.data.remote.dto;

import com.example.tvmazeapp.models.Show;

import java.util.List;

public class ShowResponse {
    private double score;
    private ShowDto show;

    public double getScore() { return score; }
    public void setScore(double value) { this.score = value; }

    public ShowDto getShow() { return show; }
    public void setShow(ShowDto value) { this.show = value; }

    public static class ShowDto {
        private String summary;
        private Image image;
        private long averageRuntime;
        private Links links;
        private String premiered;
        private Rating rating;
        private long runtime;
        private long weight;
        private String language;
        private String type;
        private String url;
        private String officialSite;
        private Network network;
        private Schedule schedule;
        private List<String> genres;
        private String name;
        private String ended;
        private long id;
        private Externals externals;
        private long updated;
        private String status;

        public String getSummary() { return summary; }
        public void setSummary(String value) { this.summary = value; }

        public Image getImage() { return image; }
        public void setImage(Image value) { this.image = value; }

        public long getAverageRuntime() { return averageRuntime; }
        public void setAverageRuntime(long value) { this.averageRuntime = value; }

        public Links getLinks() { return links; }
        public void setLinks(Links value) { this.links = value; }

        public String getPremiered() { return premiered; }
        public void setPremiered(String value) { this.premiered = value; }

        public Rating getRating() { return rating; }
        public void setRating(Rating value) { this.rating = value; }

        public long getRuntime() { return runtime; }
        public void setRuntime(long value) { this.runtime = value; }

        public long getWeight() { return weight; }
        public void setWeight(long value) { this.weight = value; }

        public String getLanguage() { return language; }
        public void setLanguage(String value) { this.language = value; }

        public String getType() { return type; }
        public void setType(String value) { this.type = value; }

        public String geturl() { return url; }
        public void seturl(String value) { this.url = value; }

        public String getOfficialSite() { return officialSite; }
        public void setOfficialSite(String value) { this.officialSite = value; }

        public Network getNetwork() { return network; }
        public void setNetwork(Network value) { this.network = value; }

        public Schedule getSchedule() { return schedule; }
        public void setSchedule(Schedule value) { this.schedule = value; }

        public List<String> getGenres() { return genres; }
        public void setGenres(List<String> value) { this.genres = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public String getEnded() { return ended; }
        public void setEnded(String value) { this.ended = value; }

        public long getid() { return id; }
        public void setid(long value) { this.id = value; }

        public Externals getExternals() { return externals; }
        public void setExternals(Externals value) { this.externals = value; }

        public long getUpdated() { return updated; }
        public void setUpdated(long value) { this.updated = value; }

        public String getStatus() { return status; }
        public void setStatus(String value) { this.status = value; }

        public Show toShow() {
            Show show = new Show();
            show.showId = id;
            show.showName = name;
            show.showPremiered = premiered;
            show.showRating = rating.average;
            show.showSite = officialSite;

            if (image != null && image.original != null) {
                show.originalPosterUrl = image.original;
            }

            if (image != null && image.medium != null) {
                show.posterUrl = image.medium;
            }

            show.showSummary = summary;
            return show;
        }

    }

    public static class Externals {
        private long thetvdb;
        private String imdb;
        private long tvrage;

        public long getThetvdb() { return thetvdb; }
        public void setThetvdb(long value) { this.thetvdb = value; }

        public String getImdb() { return imdb; }
        public void setImdb(String value) { this.imdb = value; }

        public long getTvrage() { return tvrage; }
        public void setTvrage(long value) { this.tvrage = value; }
    }

    public static class Image {
        private String original;
        private String medium;

        public String getOriginal() { return original; }
        public void setOriginal(String value) { this.original = value; }

        public String getMedium() { return medium; }
        public void setMedium(String value) { this.medium = value; }
    }

    public static class Links {
        private Previousepisode self;
        private Previousepisode previousepisode;

        public Previousepisode getSelf() { return self; }
        public void setSelf(Previousepisode value) { this.self = value; }

        public Previousepisode getPreviousepisode() { return previousepisode; }
        public void setPreviousepisode(Previousepisode value) { this.previousepisode = value; }
    }

    public static class Previousepisode {
        private String href;

        public String getHref() { return href; }
        public void setHref(String value) { this.href = value; }
    }

    public static class Network {
        private Country country;
        private String name;
        private long id;
        private String officialSite;

        public Country getCountry() { return country; }
        public void setCountry(Country value) { this.country = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public long getid() { return id; }
        public void setid(long value) { this.id = value; }

        public String getOfficialSite() { return officialSite; }
        public void setOfficialSite(String value) { this.officialSite = value; }
    }

    public static class Country {
        private String code;
        private String timezone;
        private String name;

        public String getCode() { return code; }
        public void setCode(String value) { this.code = value; }

        public String getTimezone() { return timezone; }
        public void setTimezone(String value) { this.timezone = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }
    }

    public static class Rating {
        private double average;

        public double getAverage() { return average; }
        public void setAverage(double value) { this.average = value; }
    }

    public static class Schedule {
        private List<String> days;
        private String time;

        public List<String> getDays() { return days; }
        public void setDays(List<String> value) { this.days = value; }

        public String getTime() { return time; }
        public void setTime(String value) { this.time = value; }
    }
}
