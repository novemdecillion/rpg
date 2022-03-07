create table operation_log (
  operation_id bigserial,
  mail_address character varying(255) not null,
  operation_type character varying(255) not null,
  save_at timestamp with time zone not null,

  apn_id integer,
  operation_data text,

  primary key (operation_id)
);
