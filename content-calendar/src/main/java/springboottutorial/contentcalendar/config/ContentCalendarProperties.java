package springboottutorial.contentcalendar.config;

// Useful to have types around collection of values.
/* The basic option would be define values in application.properties, but does it would not make suggestions for
types that you can use. But, with this configured, you will get the pop up options for types you can use when
you are in the application.properties
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record ContentCalendarProperties(String welcomeMessage, String about) {

}
