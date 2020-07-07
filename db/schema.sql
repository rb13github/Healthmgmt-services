CREATE TABLE employee

( employeeName varchar(100) NOT NULL,
  employeeId varchar(11) NOT NULL ,

 employeeAddress varchar(100) DEFAULT NULL,

 employeeEmail varchar(100) DEFAULT NULL,

 PRIMARY KEY (employeeId)

);

CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  name varchar(100) NOT NULL,
  brand varchar(100) NOT NULL,
  madein varchar(100) NOT NULL,
  price float NOT NULL  
);

CREATE TABLE appuser (
  username varchar(100) NOT NULL PRIMARY KEY,
  password varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  role varchar(50) NOT NULL
);



CREATE TABLE public."roleMaster"
(
    "roleId" integer NOT NULL,
    "roleDesc" text COLLATE pg_catalog."default",
    status boolean,
    CONSTRAINT "roleMaster_pkey" PRIMARY KEY ("roleId")
)

CREATE SEQUENCE public.id_seq
    INCREMENT 1
    START 1005
    MINVALUE 1001
    MAXVALUE 99999
    CACHE 1;
    
    
    CREATE TABLE public."UserMaster"
(
    "userId" integer NOT NULL,
    "userName" text COLLATE pg_catalog."default",
    fname text COLLATE pg_catalog."default",
    mname text COLLATE pg_catalog."default",
    lname text COLLATE pg_catalog."default",
    status boolean,
    password character varying(100) COLLATE pg_catalog."default",
    "roleId" integer,
    CONSTRAINT "UserMaster_pkey" PRIMARY KEY ("userId"),
    CONSTRAINT "roleId_fk" FOREIGN KEY ("roleId")
        REFERENCES public."roleMaster" ("roleId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

CREATE SEQUENCE public.invoice_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 999
    CACHE 1;
    
    
    
    CREATE TABLE public."PurchaseMaster"
(
    "InvoiceSr" integer NOT NULL,
    "ItemId" integer,
    "OnboardDate" date,
    "RefencePO" text COLLATE pg_catalog."default",
    "DeliveryChallan" text COLLATE pg_catalog."default",
    "DeliveryDate" date,
    "Qty" integer,
    "OnboardBy" integer,
    "Price" double precision,
    status boolean,
    CONSTRAINT "PurchaseMaster_pkey" PRIMARY KEY ("InvoiceSr"),
    CONSTRAINT "ItemId_fk" FOREIGN KEY ("ItemId")
        REFERENCES public."ProductMaster" ("ItemId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "userId_fk" FOREIGN KEY ("OnboardBy")
        REFERENCES public."UserMaster" ("userId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


CREATE SEQUENCE public."itemtramsId_seq"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 999
    CACHE 1;
    
    
    CREATE TABLE public."ProductAllocation"
(
    "ItemtransId" integer NOT NULL,
    "ItemCode" text COLLATE pg_catalog."default",
    "IssueQty" integer,
    "BuildingNo" integer,
    "IssueDate" date,
    "IssueBy" integer,
    "ItemId" integer,
    CONSTRAINT "ProductAllocation_pkey" PRIMARY KEY ("ItemtransId"),
    CONSTRAINT "ItemCode_fk" FOREIGN KEY ("ItemCode")
        REFERENCES public."ProductMaster" ("ItemCode") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "ItemId_fk" FOREIGN KEY ("ItemId")
        REFERENCES public."ProductMaster" ("ItemId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "userId_fk" FOREIGN KEY ("IssueBy")
        REFERENCES public."UserMaster" ("userId") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
