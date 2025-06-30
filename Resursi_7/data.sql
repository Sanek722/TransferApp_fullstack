--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-11-10 01:56:11

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
-- TOC entry 216 (class 1259 OID 16414)
-- Name: basket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.basket (
    id integer,
    author character varying,
    namebook character varying,
    price integer,
    full_value integer
);


ALTER TABLE public.basket OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16420)
-- Name: basket_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.basket_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.basket_seq OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16409)
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    id integer,
    author character varying,
    namebook character varying,
    price integer
);


ALTER TABLE public.books OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16419)
-- Name: books_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_seq OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24613)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16436)
-- Name: market; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.market (
    id integer,
    name_market character varying,
    address character varying
);


ALTER TABLE public.market OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16446)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id integer,
    id_market integer,
    name_product character varying,
    price integer
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16404)
-- Name: userdata; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.userdata (
    id integer,
    username character varying,
    password character varying
);


ALTER TABLE public.userdata OWNER TO postgres;

--
-- TOC entry 3335 (class 0 OID 16414)
-- Dependencies: 216
-- Data for Name: basket; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.basket (id, author, namebook, price, full_value) FROM stdin;
13	Толстой	Война и мир	900	0
2	Толстой	Война и мир	900	0
\.


--
-- TOC entry 3334 (class 0 OID 16409)
-- Dependencies: 215
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.books (id, author, namebook, price) FROM stdin;
3	Гоголь	Ревизор	700
4	Тургенев	Муму	500
5	bob	bob story	1000
2	Толстой	Война и мир	900
1	qewe	Муму	2222
\.


--
-- TOC entry 3338 (class 0 OID 16436)
-- Dependencies: 219
-- Data for Name: market; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.market (id, name_market, address) FROM stdin;
1	МИРЭА	Метро Юго-западная
\.


--
-- TOC entry 3339 (class 0 OID 16446)
-- Dependencies: 220
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, id_market, name_product, price) FROM stdin;
3	\N	Naruto	1500
2	\N	BOB_Story	5500
5	\N	BOB	12020
1	\N	popik	1200
\.


--
-- TOC entry 3333 (class 0 OID 16404)
-- Dependencies: 214
-- Data for Name: userdata; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.userdata (id, username, password) FROM stdin;
2	b	$2a$10$lzwGNLXKpROaaOa3DhyUM.MjAAVR9S/DdEcKPqNGDfU0h839WvOKG
3	Алексей	$2a$10$6LIydnPbK720eBVEd/Us9OFj4Rgz4YjXL7r2Rhnauepvynm0TSznu
1	bob	1234
5	sanek	$2a$10$A7M2oyHODtCDTVPgeyLBNez4S6/svtP9aBX1/yygDWxhijzPaT5N6
6	Егор	$2a$10$jmjUP97cTrgEV3w4rw.G.O2abB7Scpg1ADEcw1r.6IOUe.tJ7hnIC
8	bb	$2a$10$fclZ6glg.G34O9ttXi8RLufXC/Vq.su9mCrBRHBwrNwRt4apjESeC
111	ha	$2a$10$9EGXtsaMEQqvyafm/ZloqOQodvtaeft58vNEtqrQq6yqdRcaC7hMm
11	Катенька	$2a$10$9bHwYTtFWXjebhqA0quBmeBjdollw1iWBrqMK16LsTDMlaJZPq7JS
888	guug	$2a$10$LlZxCBG8xUJzeeQlsRo1UeF8QedfKHOPOCARZXWHre402mx9blzlK
9	1	$2a$10$6UfkUemOH3S.z4iDOA.Eleki8nPxCnlV15trgetkJjeJWCTOTkVry
23	2	$2a$10$/NxfowH9Dq9mxZq/gIvIQuL3Prc7oXZypDfByweJvpKYu4DkLugV2
\.


--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 218
-- Name: basket_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.basket_seq', 1, false);


--
-- TOC entry 3347 (class 0 OID 0)
-- Dependencies: 217
-- Name: books_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_seq', 101, true);


--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 221
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 4, true);


-- Completed on 2023-11-10 01:56:11

--
-- PostgreSQL database dump complete
--

