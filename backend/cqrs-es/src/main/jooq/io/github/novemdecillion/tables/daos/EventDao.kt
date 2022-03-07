/*
 * This file is generated by jOOQ.
 */
package io.github.novemdecillion.tables.daos


import io.github.novemdecillion.tables.EventTable
import io.github.novemdecillion.tables.pojos.EventEntity
import io.github.novemdecillion.tables.records.EventRecord

import java.time.OffsetDateTime
import java.util.UUID

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.JSONB
import org.jooq.impl.DAOImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class EventDao(configuration: Configuration?) : DAOImpl<EventRecord, EventEntity, Long>(EventTable.EVENT, EventEntity::class.java, configuration) {

    /**
     * Create a new EventDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: EventEntity): Long? = o.eventId

    /**
     * Fetch records that have <code>event_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    fun fetchRangeOfEventIdTable(lowerInclusive: Long?, upperInclusive: Long?): List<EventEntity> = fetchRange(EventTable.EVENT.EVENT_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>event_id IN (values)</code>
     */
    fun fetchByEventIdTable(vararg values: Long): List<EventEntity> = fetch(EventTable.EVENT.EVENT_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>event_id = value</code>
     */
    fun fetchOneByEventIdTable(value: Long): EventEntity? = fetchOne(EventTable.EVENT.EVENT_ID, value)

    /**
     * Fetch records that have <code>aggregate_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    fun fetchRangeOfAggregateIdTable(lowerInclusive: UUID?, upperInclusive: UUID?): List<EventEntity> = fetchRange(EventTable.EVENT.AGGREGATE_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>aggregate_id IN (values)</code>
     */
    fun fetchByAggregateIdTable(vararg values: UUID): List<EventEntity> = fetch(EventTable.EVENT.AGGREGATE_ID, *values)

    /**
     * Fetch records that have <code>command_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    fun fetchRangeOfCommandNameTable(lowerInclusive: String?, upperInclusive: String?): List<EventEntity> = fetchRange(EventTable.EVENT.COMMAND_NAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>command_name IN (values)</code>
     */
    fun fetchByCommandNameTable(vararg values: String): List<EventEntity> = fetch(EventTable.EVENT.COMMAND_NAME, *values)

    /**
     * Fetch records that have <code>payload BETWEEN lowerInclusive AND upperInclusive</code>
     */
    fun fetchRangeOfPayloadTable(lowerInclusive: JSONB?, upperInclusive: JSONB?): List<EventEntity> = fetchRange(EventTable.EVENT.PAYLOAD, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>payload IN (values)</code>
     */
    fun fetchByPayloadTable(vararg values: JSONB): List<EventEntity> = fetch(EventTable.EVENT.PAYLOAD, *values)

    /**
     * Fetch records that have <code>save_at BETWEEN lowerInclusive AND upperInclusive</code>
     */
    fun fetchRangeOfSaveAtTable(lowerInclusive: OffsetDateTime?, upperInclusive: OffsetDateTime?): List<EventEntity> = fetchRange(EventTable.EVENT.SAVE_AT, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>save_at IN (values)</code>
     */
    fun fetchBySaveAtTable(vararg values: OffsetDateTime): List<EventEntity> = fetch(EventTable.EVENT.SAVE_AT, *values)
}
