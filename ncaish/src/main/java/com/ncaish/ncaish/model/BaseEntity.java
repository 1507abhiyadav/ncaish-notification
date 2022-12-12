package com.ncaish.ncaish.model;

// public class BaseEntiyt {
    
// }

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new base entity.
 */
@NoArgsConstructor
public class BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	// private static final long serialVersionUID = -4893735896593278139L;

	/** The id. */
	private String id;

	/** The object id. */
	// private String objectId = UUID.randomUUID().toString();

	// /** The updatedby. */
	// private String updatedby;

	// /** The created by. */
	// private String createdBy;

	// /** The deleted by. */
	// private String deletedBy;

	// /** The deleted by. */
	// private long deletedAt;

	// /** The updated at. */
	// private long updatedAt = new Date().getTime();

	// /** The created at. */
	// private long createdAt = new Date().getTime();

	/** The archive. */
	private boolean archive;

}