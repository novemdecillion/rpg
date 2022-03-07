create sequence event_id_seq as bigint cycle;

create table event (
  event_id bigint not null default nextval('event_id_seq'),
  aggregate_id uuid not null,
  command_name character varying(512),
  payload jsonb not null,
  save_at timestamp with time zone default now(),
  primary key (event_id)
);

alter sequence event_id_seq owned by event.event_id;

create table snapshot (
  aggregate_id uuid not null,
  event_id bigint not null,
  payload jsonb not null,
  primary key (aggregate_id)
);
