-- NEWS TABLE
INSERT INTO public.news
(id, author, "content", "date", tags, title)
VALUES('ed80eca5-4ad3-4aba-8685-466dc860ee6d'::uuid, 'N Author', 'N Content', '2022-02-22 16:02:59.430', 'N Tags', 'Filter Title');
INSERT INTO public.news
(id, author, "content", "date", tags, title)
VALUES('2650acc8-7e41-46cc-a397-3c5adc855774'::uuid, 'N Author', 'N Content', '2022-02-22 16:09:57.152', 'N Tags', 'Fila Title');
INSERT INTO public.news
(id, author, "content", "date", tags, title)
VALUES('9a8c37ca-ccf1-4667-9f56-9f603534bba1'::uuid, 'N Author', 'N Content', '2022-02-22 20:52:14.000', 'N fissura', 'Fila Title');
INSERT INTO public.news
(id, author, "content", "date", tags, title)
VALUES('a2c1eb72-d05a-47b6-bd53-e503e218df3d'::uuid, 'N Author', 'N Content', '2022-02-22 21:41:45.393', 'N fissura', 'Fila DOWN');
INSERT INTO public.news
(id, author, "content", "date", tags, title)
VALUES('a2ef50b8-b22a-499a-ae05-33ac46aee63b'::uuid, 'N Author', 'N Content', '2022-02-22 21:42:59.162', 'N fissura', 'Fila DOWN');
INSERT INTO public.news
(id, author, "content", "date", tags, title)
VALUES('29d90c07-e8c1-48de-9b6c-dcd00399358d'::uuid, 'Author Updated', 'Content Updated', '2022-02-22 23:24:34.149', 'Tags Updated FORM', 'Title Updated');


--COMMENT TABLE

INSERT INTO public."comment"
(id, author, "content", "date", pk_news)
VALUES('4b507224-0e8b-44d4-97b4-fc66acc99879'::uuid, 'N Author', 'N Content', '2022-02-22 15:43:13.159', '29d90c07-e8c1-48de-9b6c-dcd00399358d'::uuid);
INSERT INTO public."comment"
(id, author, "content", "date", pk_news)
VALUES('296bfd3c-4309-4e81-89c1-c45038ae917a'::uuid, 'N Author', 'N Content', '2022-02-22 15:43:13.545', '29d90c07-e8c1-48de-9b6c-dcd00399358d'::uuid);
INSERT INTO public."comment"
(id, author, "content", "date", pk_news)
VALUES('c3974888-acaa-47aa-a311-8fcd1de43fa8'::uuid, 'N Author', 'N Content', '2022-02-22 15:43:13.927', '29d90c07-e8c1-48de-9b6c-dcd00399358d'::uuid);