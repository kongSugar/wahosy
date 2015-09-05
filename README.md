# SahoSy

[Trello](https://trello.com/b/TbM1DAna)

Todo:
- [ ] muhahah
- [x] nope

Library for accessing the TheTVDB-API in Java
This library caches all requests in an embedded database to relieve slow connections and server.

##Usage

####Configuration:
```java
TVDB tvDB = new TVDB("your apikey");

for automatic updates every 30minutes while running:
TVDB tvDB = new TVDB("your apikey", true);
```
---
####Get a List of supported languages
```java
List<Language> languages = tvDB.getLanguages();

for(Language l:languages){
    String            id = l.getID();
    String          name = l.getName();
    String  abbreviation = l.getAbbreviation();
}
```
---
```java
List<Series>  seriesList = tvDB.findSeries(  "<title>","<lang_abbreviation>");
Series            series = tvDB.getSeries(  series_id,"<lang_abbreviation>");

List<Episode>episodeList = tvDB.getEpisodeList( series_id,"<lang_abbreviation>");
Episode          episode = tvDB.getEpisode(episode_id,"<lang_abbreviation>");
Episode          episode = tvDB.getEpisode( series_id,"<lang_abbreviation>",season,episode);

List<Banner>  bannerList = tvDB.getBannerList(  series_id);
Banner            banner = tvDB.getBanner(  banner_id);


```
---
####To run tests
Create a file called gradle.properties containing following line
```
systemProp.apikey=<YOUR_API_KEY>
```
and run test task in your ide´s gradle plugin or run following line on your terminal
```
gradle test
```


##License

[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)

---
http://thetvdb.com/