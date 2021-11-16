package com.postgres.fulltextsearch.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


/**
 * The persistent class for the fts_global database table.
 * 
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fts_global")
@Data
public class FtsGlobal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID ftsGlobalId;

	@Column(name="fts_description_name_token")
	private String ftsDescriptionNameToken;

	@Column(name="fts_one_name_token")
	private String ftsOneNameToken;

	private String status;

	//bi-directional many-to-one association to FtsOne
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fts_one_id")
	private FtsOne ftsOne;
}