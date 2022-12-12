package com.ncaish.ncaish.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Document(collection = "event_config")
// public class Event {

//     // @Id   
//     private String event;
//     private Boolean sms;
//     private Boolean email;
//     private Boolean push;
//     private String subject;
//     private String emailTemplate;
//     private String archive;
//     private String screen;
    
// }
// public class EventConfigEO{
public class EventConfigEO extends BaseEntity {


	/** The event. */
	private String event;

	/** The sms. */
	private boolean sms;

	/** The email. */
	private boolean email;

	/** The push. */
	private boolean push;

	/** The sms template. */
	private String smsTemplate;

	/** The email template. */
	private String emailTemplate;

	/** The push template. */
	private String pushTemplate;

	/** The subject. */
	private String subject;

	private String screen;

	// private boolean html;
}
