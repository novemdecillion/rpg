/*
 * This file is generated by jOOQ.
 */
package io.github.novemdecillion.tables.records


import io.github.novemdecillion.tables.SnapshotTable
import io.github.novemdecillion.tables.interfaces.ISnapshot

import java.util.UUID

import org.jooq.Field
import org.jooq.JSONB
import org.jooq.Record1
import org.jooq.Record3
import org.jooq.Row3
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class SnapshotRecord() : UpdatableRecordImpl<SnapshotRecord>(SnapshotTable.SNAPSHOT), Record3<UUID?, Long?, JSONB?>, ISnapshot {

    override var aggregateId: UUID?
        set(value) = set(0, value)
        get() = get(0) as UUID?

    override var eventId: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    override var payload: JSONB?
        set(value) = set(2, value)
        get() = get(2) as JSONB?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<UUID?> = super.key() as Record1<UUID?>

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row3<UUID?, Long?, JSONB?> = super.fieldsRow() as Row3<UUID?, Long?, JSONB?>
    override fun valuesRow(): Row3<UUID?, Long?, JSONB?> = super.valuesRow() as Row3<UUID?, Long?, JSONB?>
    override fun field1(): Field<UUID?> = SnapshotTable.SNAPSHOT.AGGREGATE_ID
    override fun field2(): Field<Long?> = SnapshotTable.SNAPSHOT.EVENT_ID
    override fun field3(): Field<JSONB?> = SnapshotTable.SNAPSHOT.PAYLOAD
    override fun component1(): UUID? = aggregateId
    override fun component2(): Long? = eventId
    override fun component3(): JSONB? = payload
    override fun value1(): UUID? = aggregateId
    override fun value2(): Long? = eventId
    override fun value3(): JSONB? = payload

    override fun value1(value: UUID?): SnapshotRecord {
        this.aggregateId = value
        return this
    }

    override fun value2(value: Long?): SnapshotRecord {
        this.eventId = value
        return this
    }

    override fun value3(value: JSONB?): SnapshotRecord {
        this.payload = value
        return this
    }

    override fun values(value1: UUID?, value2: Long?, value3: JSONB?): SnapshotRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        return this
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    override fun from(from: ISnapshot) {
        aggregateId = from.aggregateId
        eventId = from.eventId
        payload = from.payload
    }

    override fun <E : ISnapshot> into(into: E): E {
        into.from(this)
        return into
    }

    /**
     * Create a detached, initialised SnapshotRecord
     */
    constructor(aggregateId: UUID? = null, eventId: Long? = null, payload: JSONB? = null): this() {
        this.aggregateId = aggregateId
        this.eventId = eventId
        this.payload = payload
    }
}
