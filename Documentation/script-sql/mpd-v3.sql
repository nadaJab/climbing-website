
CREATE SEQUENCE public.account_id_compte_seq;

CREATE TABLE public.account (
                id_compte INTEGER NOT NULL DEFAULT nextval('public.account_id_compte_seq'),
                email VARCHAR NOT NULL,
                password VARCHAR NOT NULL,
                CONSTRAINT account_pk PRIMARY KEY (id_compte)
);


ALTER SEQUENCE public.account_id_compte_seq OWNED BY public.account.id_compte;

CREATE SEQUENCE public.user_web_id_user_seq;

CREATE TABLE public.user_Web (
                id_user INTEGER NOT NULL DEFAULT nextval('public.user_web_id_user_seq'),
                pseudo VARCHAR NOT NULL,
                first_name VARCHAR NOT NULL,
                last_name VARCHAR NOT NULL,
                climbing_type VARCHAR NOT NULL,
                birth_year DATE NOT NULL,
                genre VARCHAR NOT NULL,
                role VARCHAR NOT NULL DEFAULT 'utilisateur',
                id_compte INTEGER NOT NULL,
                CONSTRAINT user_web_pk PRIMARY KEY (id_user)
);


ALTER SEQUENCE public.user_web_id_user_seq OWNED BY public.user_Web.id_user;

CREATE SEQUENCE public.comment_id_comment_seq;

CREATE TABLE public.comment (
                id_comment INTEGER NOT NULL DEFAULT nextval('public.comment_id_comment_seq'),
                content VARCHAR NOT NULL,
                date_coment DATE NOT NULL,
                id_user INTEGER NOT NULL,
                CONSTRAINT comment_pk PRIMARY KEY (id_comment)
);


ALTER SEQUENCE public.comment_id_comment_seq OWNED BY public.comment.id_comment;

CREATE SEQUENCE public.country_id_city_country_seq_1;

CREATE TABLE public.country (
                id_city_country INTEGER NOT NULL DEFAULT nextval('public.country_id_city_country_seq_1'),
                city_name VARCHAR NOT NULL,
                country_name VARCHAR NOT NULL,
                CONSTRAINT country_pk PRIMARY KEY (id_city_country)
);


ALTER SEQUENCE public.country_id_city_country_seq_1 OWNED BY public.country.id_city_country;

CREATE SEQUENCE public.route_id_route_seq;

CREATE TABLE public.route (
                id_route INTEGER NOT NULL DEFAULT nextval('public.route_id_route_seq'),
                route_name VARCHAR NOT NULL,
                cotation VARCHAR NOT NULL,
                height INTEGER NOT NULL,
                point_number INTEGER,
                route_opener VARCHAR,
                opening_year INTEGER,
                CONSTRAINT route_pk PRIMARY KEY (id_route)
);


ALTER SEQUENCE public.route_id_route_seq OWNED BY public.route.id_route;

CREATE SEQUENCE public.sector_id_sector_seq;

CREATE TABLE public.sector (
                id_sector INTEGER NOT NULL DEFAULT nextval('public.sector_id_sector_seq'),
                sector_name VARCHAR NOT NULL,
                CONSTRAINT sector_pk PRIMARY KEY (id_sector)
);


ALTER SEQUENCE public.sector_id_sector_seq OWNED BY public.sector.id_sector;

CREATE TABLE public.sector_route (
                id_route INTEGER NOT NULL,
                id_sector INTEGER NOT NULL,
                CONSTRAINT sector_route_pk PRIMARY KEY (id_route, id_sector)
);


CREATE SEQUENCE public.topo_id_topo_seq;

CREATE TABLE public.topo (
                id_topo INTEGER NOT NULL DEFAULT nextval('public.topo_id_topo_seq'),
                topo_name VARCHAR NOT NULL,
                author VARCHAR NOT NULL,
                nb_copy_max INTEGER NOT NULL,
                edition_year INTEGER,
                published DATE,
                CONSTRAINT topo_pk PRIMARY KEY (id_topo)
);


ALTER SEQUENCE public.topo_id_topo_seq OWNED BY public.topo.id_topo;

CREATE SEQUENCE public.booking_topo_id_bookingtopo_seq;

CREATE TABLE public.booking_topo (
                id_bookingTopo INTEGER NOT NULL DEFAULT nextval('public.booking_topo_id_bookingtopo_seq'),
                borrowing_date DATE NOT NULL,
                return_date DATE NOT NULL,
                id_topo INTEGER NOT NULL,
                id_user INTEGER NOT NULL,
				return_confirmation BOOLEAN DEFAULT 'false'
                CONSTRAINT booking_topo_pk PRIMARY KEY (id_bookingTopo)
);


ALTER SEQUENCE public.booking_topo_id_bookingtopo_seq OWNED BY public.booking_topo.id_bookingTopo;

CREATE TABLE public.list_topo (
                id_topo INTEGER NOT NULL,
                id_user INTEGER NOT NULL,
                CONSTRAINT list_topo_pk PRIMARY KEY (id_topo, id_user)
);


CREATE TABLE public.comment_topo (
                id_comment INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                CONSTRAINT comment_topo_pk PRIMARY KEY (id_comment, id_topo)
);


CREATE SEQUENCE public.spot_id_spot_seq;

CREATE TABLE public.spot (
                id_spot INTEGER NOT NULL DEFAULT nextval('public.spot_id_spot_seq'),
                id_city_country INTEGER NOT NULL,
                spot_name VARCHAR NOT NULL,
                total_routes_nb INTEGER,
                cotation_max VARCHAR,
                cotation_min VARCHAR,
                orientation VARCHAR NOT NULL,
                climbing_type VARCHAR NOT NULL,
                CONSTRAINT spot_pk PRIMARY KEY (id_spot)
);


ALTER SEQUENCE public.spot_id_spot_seq OWNED BY public.spot.id_spot;

CREATE TABLE public.spot_sector (
                id_spot INTEGER NOT NULL,
                id_sector INTEGER NOT NULL,
                CONSTRAINT spot_sector_pk PRIMARY KEY (id_spot, id_sector)
);


CREATE TABLE public.topo_spot (
                id_topo INTEGER NOT NULL,
                id_spot INTEGER NOT NULL,
                CONSTRAINT topo_spot_pk PRIMARY KEY (id_topo, id_spot)
);


CREATE TABLE public.comment_spot (
                id_comment INTEGER NOT NULL,
                id_spot INTEGER NOT NULL,
                CONSTRAINT comment_spot_pk PRIMARY KEY (id_comment, id_spot)
);


ALTER TABLE public.user_Web ADD CONSTRAINT account_user_fk
FOREIGN KEY (id_compte)
REFERENCES public.account (id_compte)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment ADD CONSTRAINT user_comment_fk
FOREIGN KEY (id_user)
REFERENCES public.user_Web (id_user)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.list_topo ADD CONSTRAINT user_listtopo_fk
FOREIGN KEY (id_user)
REFERENCES public.user_Web (id_user)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.booking_topo ADD CONSTRAINT user_bookingtopo_fk
FOREIGN KEY (id_user)
REFERENCES public.user_Web (id_user)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment_spot ADD CONSTRAINT comment_commentspot_fk
FOREIGN KEY (id_comment)
REFERENCES public.comment (id_comment)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment_topo ADD CONSTRAINT comment_commenttopo_fk
FOREIGN KEY (id_comment)
REFERENCES public.comment (id_comment)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.spot ADD CONSTRAINT country_spot_fk
FOREIGN KEY (id_city_country)
REFERENCES public.country (id_city_country)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sector_route ADD CONSTRAINT route_sectorroute_fk
FOREIGN KEY (id_route)
REFERENCES public.route (id_route)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.sector_route ADD CONSTRAINT sector_sectorroute_fk
FOREIGN KEY (id_sector)
REFERENCES public.sector (id_sector)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.spot_sector ADD CONSTRAINT sector_spotsector_fk
FOREIGN KEY (id_sector)
REFERENCES public.sector (id_sector)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment_topo ADD CONSTRAINT topo_commenttopo_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.list_topo ADD CONSTRAINT topo_listtopo_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.booking_topo ADD CONSTRAINT topo_bookingtopo_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_spot ADD CONSTRAINT topo_toposite_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.comment_spot ADD CONSTRAINT spot_commentspot_fk
FOREIGN KEY (id_spot)
REFERENCES public.spot (id_spot)
ON DELETE CASCADE
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo_spot ADD CONSTRAINT spot_toposite_fk
FOREIGN KEY (id_spot)
REFERENCES public.spot (id_spot)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.spot_sector ADD CONSTRAINT spot_spotsector_fk
FOREIGN KEY (id_spot)
REFERENCES public.spot (id_spot)
ON DELETE CASCADE
ON UPDATE CASCADE
NOT DEFERRABLE;
