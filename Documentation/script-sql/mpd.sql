
CREATE SEQUENCE public.account_id_compte_seq_1;

CREATE TABLE public.Account (
                id_compte INTEGER NOT NULL DEFAULT nextval('public.account_id_compte_seq_1'),
                email VARCHAR NOT NULL,
                password VARCHAR NOT NULL,
                CONSTRAINT account_pk PRIMARY KEY (id_compte)
);


ALTER SEQUENCE public.account_id_compte_seq_1 OWNED BY public.Account.id_compte;

CREATE TABLE public.User_1 (
                pseudo VARCHAR NOT NULL,
                first_name VARCHAR NOT NULL,
                last_name VARCHAR NOT NULL,
                climbing_type VARCHAR NOT NULL,
                birth_year DATE NOT NULL,
                genre VARCHAR NOT NULL,
                role VARCHAR NOT NULL,
                id_compte INTEGER NOT NULL,
                CONSTRAINT user_1_pk PRIMARY KEY (pseudo)
);


CREATE SEQUENCE public.comment_id_comment_seq;

CREATE TABLE public.Comment (
                id_comment INTEGER NOT NULL DEFAULT nextval('public.comment_id_comment_seq'),
                content VARCHAR NOT NULL,
                date_coment DATE NOT NULL,
                pseudo VARCHAR NOT NULL,
                CONSTRAINT comment_pk PRIMARY KEY (id_comment)
);


ALTER SEQUENCE public.comment_id_comment_seq OWNED BY public.Comment.id_comment;

CREATE SEQUENCE public.country_id_country_seq_1;

CREATE TABLE public.Country (
                id_country INTEGER NOT NULL DEFAULT nextval('public.country_id_country_seq_1'),
                country_name VARCHAR NOT NULL,
                CONSTRAINT country_pk PRIMARY KEY (id_country)
);


ALTER SEQUENCE public.country_id_country_seq_1 OWNED BY public.Country.id_country;

CREATE SEQUENCE public.city_id_city_seq_1;

CREATE TABLE public.City (
                id_country INTEGER NOT NULL,
                id_city INTEGER NOT NULL DEFAULT nextval('public.city_id_city_seq_1'),
                city_name VARCHAR NOT NULL,
                CONSTRAINT city_pk PRIMARY KEY (id_country, id_city)
);


ALTER SEQUENCE public.city_id_city_seq_1 OWNED BY public.City.id_city;

CREATE SEQUENCE public.topo_id_topo_seq;

CREATE TABLE public.Topo (
                id_topo INTEGER NOT NULL DEFAULT nextval('public.topo_id_topo_seq'),
                topo_name VARCHAR NOT NULL,
                author VARCHAR NOT NULL,
                nb_copy_max INTEGER NOT NULL,
                edition_year INTEGER,
                published DATE,
                image_URL VARCHAR NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id_topo)
);


ALTER SEQUENCE public.topo_id_topo_seq OWNED BY public.Topo.id_topo;

CREATE SEQUENCE public.bookingtopo_id_bookingtopo_seq;

CREATE TABLE public.BookingTopo (
                id_bookingTopo INTEGER NOT NULL DEFAULT nextval('public.bookingtopo_id_bookingtopo_seq'),
                borrowing_date DATE NOT NULL,
                return_date DATE NOT NULL,
                id_topo INTEGER NOT NULL,
                pseudo VARCHAR NOT NULL,
                CONSTRAINT bookingtopo_pk PRIMARY KEY (id_bookingTopo)
);


ALTER SEQUENCE public.bookingtopo_id_bookingtopo_seq OWNED BY public.BookingTopo.id_bookingTopo;

CREATE TABLE public.ListTopo (
                pseudo VARCHAR NOT NULL,
                id_topo INTEGER NOT NULL,
                nb_copy INTEGER NOT NULL,
                CONSTRAINT listtopo_pk PRIMARY KEY (pseudo, id_topo)
);


CREATE TABLE public.CommentTopo (
                id_comment INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                CONSTRAINT commenttopo_pk PRIMARY KEY (id_comment, id_topo)
);


CREATE SEQUENCE public.spot_id_spot_seq;

CREATE TABLE public.Spot (
                id_spot INTEGER NOT NULL DEFAULT nextval('public.spot_id_spot_seq'),
                spot_name VARCHAR NOT NULL,
                total_routes_nb INTEGER,
                cotation_max VARCHAR,
                cotation_min VARCHAR,
                orientation VARCHAR NOT NULL,
                climbing_type VARCHAR NOT NULL,
                id_city INTEGER NOT NULL,
                id_country INTEGER NOT NULL,
                CONSTRAINT spot_pk PRIMARY KEY (id_spot)
);


ALTER SEQUENCE public.spot_id_spot_seq OWNED BY public.Spot.id_spot;

CREATE TABLE public.TopoSite (
                id_topo INTEGER NOT NULL,
                id_spot INTEGER NOT NULL,
                CONSTRAINT toposite_pk PRIMARY KEY (id_topo, id_spot)
);


CREATE SEQUENCE public.sector_id_sector_seq;

CREATE TABLE public.Sector (
                id_sector INTEGER NOT NULL DEFAULT nextval('public.sector_id_sector_seq'),
                sector_name VARCHAR NOT NULL,
                nb_routes INTEGER NOT NULL,
                id_spot INTEGER NOT NULL,
                CONSTRAINT sector_pk PRIMARY KEY (id_sector)
);


ALTER SEQUENCE public.sector_id_sector_seq OWNED BY public.Sector.id_sector;

CREATE SEQUENCE public.route_id_route_seq;

CREATE TABLE public.Route (
                id_route INTEGER NOT NULL DEFAULT nextval('public.route_id_route_seq'),
                route_name VARCHAR NOT NULL,
                cotation VARCHAR NOT NULL,
                height INTEGER NOT NULL,
                point_number INTEGER,
                route_opener VARCHAR,
                opening_year INTEGER,
                id_sector INTEGER NOT NULL,
                CONSTRAINT route_pk PRIMARY KEY (id_route)
);


ALTER SEQUENCE public.route_id_route_seq OWNED BY public.Route.id_route;

CREATE TABLE public.CommentSpot (
                id_comment INTEGER NOT NULL,
                id_spot INTEGER NOT NULL,
                CONSTRAINT commentspot_pk PRIMARY KEY (id_comment, id_spot)
);


ALTER TABLE public.User_1 ADD CONSTRAINT account_user_fk
FOREIGN KEY (id_compte)
REFERENCES public.Account (id_compte)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Comment ADD CONSTRAINT user_comment_fk
FOREIGN KEY (pseudo)
REFERENCES public.User_1 (pseudo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ListTopo ADD CONSTRAINT user_listtopo_fk
FOREIGN KEY (pseudo)
REFERENCES public.User_1 (pseudo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.BookingTopo ADD CONSTRAINT user_bookingtopo_fk
FOREIGN KEY (pseudo)
REFERENCES public.User_1 (pseudo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CommentSpot ADD CONSTRAINT comment_commentspot_fk
FOREIGN KEY (id_comment)
REFERENCES public.Comment (id_comment)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CommentTopo ADD CONSTRAINT comment_commenttopo_fk
FOREIGN KEY (id_comment)
REFERENCES public.Comment (id_comment)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.City ADD CONSTRAINT country_city_fk
FOREIGN KEY (id_country)
REFERENCES public.Country (id_country)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Spot ADD CONSTRAINT city_spot_fk
FOREIGN KEY (id_country, id_city)
REFERENCES public.City (id_country, id_city)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CommentTopo ADD CONSTRAINT topo_commenttopo_fk
FOREIGN KEY (id_topo)
REFERENCES public.Topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ListTopo ADD CONSTRAINT topo_listtopo_fk
FOREIGN KEY (id_topo)
REFERENCES public.Topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.BookingTopo ADD CONSTRAINT topo_bookingtopo_fk
FOREIGN KEY (id_topo)
REFERENCES public.Topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TopoSite ADD CONSTRAINT topo_toposite_fk
FOREIGN KEY (id_topo)
REFERENCES public.Topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.CommentSpot ADD CONSTRAINT spot_commentspot_fk
FOREIGN KEY (id_spot)
REFERENCES public.Spot (id_spot)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Sector ADD CONSTRAINT spot_sector_fk
FOREIGN KEY (id_spot)
REFERENCES public.Spot (id_spot)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TopoSite ADD CONSTRAINT spot_toposite_fk
FOREIGN KEY (id_spot)
REFERENCES public.Spot (id_spot)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Route ADD CONSTRAINT sector_route_fk
FOREIGN KEY (id_sector)
REFERENCES public.Sector (id_sector)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
