--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Ubuntu 14.0-1.pgdg18.04+1)
-- Dumped by pg_dump version 14.0 (Ubuntu 14.0-1.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: driw_db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE driw_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';


ALTER DATABASE driw_db OWNER TO postgres;

\connect driw_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: item; Type: TABLE; Schema: public; Owner: app_user
--

CREATE TABLE public.item (
    item_id integer NOT NULL,
    item_name character varying(200) NOT NULL,
    carton_price numeric(12,3) NOT NULL,
    carton_size integer NOT NULL
);


ALTER TABLE public.item OWNER TO app_user;

--
-- Name: item_item_id_seq; Type: SEQUENCE; Schema: public; Owner: app_user
--

CREATE SEQUENCE public.item_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.item_item_id_seq OWNER TO app_user;

--
-- Name: item_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: app_user
--

ALTER SEQUENCE public.item_item_id_seq OWNED BY public.item.item_id;


--
-- Name: item item_id; Type: DEFAULT; Schema: public; Owner: app_user
--

ALTER TABLE ONLY public.item ALTER COLUMN item_id SET DEFAULT nextval('public.item_item_id_seq'::regclass);


--
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: app_user
--

COPY public.item (item_id, item_name, carton_price, carton_size) FROM stdin;
1	Penguin-Ears	175.000	20
2	Horseshoe	875.000	5
\.


--
-- Name: item_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: app_user
--

SELECT pg_catalog.setval('public.item_item_id_seq', 1, false);


--
-- Name: item item_pk; Type: CONSTRAINT; Schema: public; Owner: app_user
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pk PRIMARY KEY (item_id);


--
-- Name: DATABASE driw_db; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON DATABASE driw_db TO app_user;


--
-- PostgreSQL database dump complete
--

