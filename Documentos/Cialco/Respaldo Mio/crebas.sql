/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     01/03/2016 12:37:12                          */
/*==============================================================*/


drop index MENMEN_FK;

drop index MENU_PK;

drop table MENU;

drop index PERFIL_PK;

drop table PERFIL;

drop index PRFMEN_FK;

drop index PRFMEN2_FK;

drop index PRFMEN_PK;

drop table PERFILMENU;

drop index USRPTO_FK;

drop index PRODUCTOR_PK;

drop table PRODUCTOR;

drop index USUARIO_PK;

drop table USUARIO;

drop index USRPRF2_FK;

drop index USRPRF_FK;

drop index USRPRF_PK;

drop table USUARIOPERFIL;

drop domain ESTADO;

drop domain FECHACREACION;

/*==============================================================*/
/* Domain: ESTADO                                               */
/*==============================================================*/
create domain ESTADO as CHAR(1);

/*==============================================================*/
/* Domain: FECHACREACION                                        */
/*==============================================================*/
create domain FECHACREACION as DATE;

/*==============================================================*/
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU (
   MENID                INT8                 not null,
   MEN_MENID            INT8                 null,
   MENDESCRIPCION       VARCHAR(250)         null,
   MENURL               VARCHAR(250)         null,
   MENFECHACREACION     FECHACREACION        null,
   MENESTADO            ESTADO               null,
   constraint PK_MENU primary key (MENID)
);

comment on table MENU is
'Contiene las direcciones para armar el menu dinamico de acuerdo al perfil';

/*==============================================================*/
/* Index: MENU_PK                                               */
/*==============================================================*/
create unique index MENU_PK on MENU (
MENID
);

/*==============================================================*/
/* Index: MENMEN_FK                                             */
/*==============================================================*/
create  index MENMEN_FK on MENU (
MEN_MENID
);

/*==============================================================*/
/* Table: PERFIL                                                */
/*==============================================================*/
create table PERFIL (
   PRFID                INT8                 not null,
   PRFDESCRIPCION       CHAR(250)            null,
   PRFCREACION          BOOL                 null,
   PRFEDISION           BOOL                 null,
   PRFCONSULTA          BOOL                 null,
   PRFELIMINACION       BOOL                 null,
   PRFFECHACREACION     FECHACREACION        null,
   PRFESTADO            ESTADO               null,
   constraint PK_PERFIL primary key (PRFID)
);

/*==============================================================*/
/* Index: PERFIL_PK                                             */
/*==============================================================*/
create unique index PERFIL_PK on PERFIL (
PRFID
);

/*==============================================================*/
/* Table: PERFILMENU                                            */
/*==============================================================*/
create table PERFILMENU (
   MENID                INT8                 not null,
   PRFID                INT8                 not null,
   constraint PK_PERFILMENU primary key (MENID, PRFID)
);

comment on table PERFILMENU is
'Un perfil puede tener varios menus y un menu puede estar en varios perfiles';

/*==============================================================*/
/* Index: PRFMEN_PK                                             */
/*==============================================================*/
create unique index PRFMEN_PK on PERFILMENU (
MENID,
PRFID
);

/*==============================================================*/
/* Index: PRFMEN2_FK                                            */
/*==============================================================*/
create  index PRFMEN2_FK on PERFILMENU (
PRFID
);

/*==============================================================*/
/* Index: PRFMEN_FK                                             */
/*==============================================================*/
create  index PRFMEN_FK on PERFILMENU (
MENID
);

/*==============================================================*/
/* Table: PRODUCTOR                                             */
/*==============================================================*/
create table PRODUCTOR (
   PTOID                INT8                 not null,
   USRID                INT8                 null,
   PTONUMEROCEDULA      CHAR(10)             null,
   PTONOMBRES           VARCHAR(250)         null,
   PTOAPELLIDOS         VARCHAR(250)         null,
   PTOEDAD              NUMERIC(3)           null,
   PTOTELEFONOFIJO      CHAR(9)              null,
   PTOCELULAR           CHAR(10)             null,
   PTOEMAIL             CHAR(300)            null,
   PTOFECHACREACION     FECHACREACION        null,
   PTOESTADO            ESTADO               null,
   constraint PK_PRODUCTOR primary key (PTOID)
);

comment on table PRODUCTOR is
'Informacion general del productor';

/*==============================================================*/
/* Index: PRODUCTOR_PK                                          */
/*==============================================================*/
create unique index PRODUCTOR_PK on PRODUCTOR (
PTOID
);

/*==============================================================*/
/* Index: USRPTO_FK                                             */
/*==============================================================*/
create  index USRPTO_FK on PRODUCTOR (
USRID
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   USRID                INT8                 not null,
   USRUSUARIO           VARCHAR(10)          null,
   USRCONTRASENA        VARCHAR(10)          null,
   USRNOMBRE            CHAR(250)            null,
   USRAPELLIDO          CHAR(250)            null,
   USRIDENTIFICACION    CHAR(13)             null,
   USRTELEFONO          CHAR(9)              null,
   USREXTENSION         CHAR(5)              null,
   USRCELULAR           CHAR(10)             null,
   USRFECHACREACION     FECHACREACION        null,
   USRESTADO            ESTADO               null,
   constraint PK_USUARIO primary key (USRID)
);

comment on table USUARIO is
'Información solo del usuario';

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
USRID
);

/*==============================================================*/
/* Table: USUARIOPERFIL                                         */
/*==============================================================*/
create table USUARIOPERFIL (
   USRID                INT8                 not null,
   PRFID                INT8                 not null,
   UPFFECHACADUCIDAD    DATE                 null,
   constraint PK_USUARIOPERFIL primary key (USRID, PRFID)
);

comment on table USUARIOPERFIL is
'Usuario puede tener varios perfiles y un perfil puede tener varios usuarios';

/*==============================================================*/
/* Index: USRPRF_PK                                             */
/*==============================================================*/
create unique index USRPRF_PK on USUARIOPERFIL (
USRID,
PRFID
);

/*==============================================================*/
/* Index: USRPRF_FK                                             */
/*==============================================================*/
create  index USRPRF_FK on USUARIOPERFIL (
USRID
);

/*==============================================================*/
/* Index: USRPRF2_FK                                            */
/*==============================================================*/
create  index USRPRF2_FK on USUARIOPERFIL (
PRFID
);

alter table MENU
   add constraint FK_MENU_MENMEN_MENU foreign key (MEN_MENID)
      references MENU (MENID)
      on delete restrict on update restrict;

alter table PERFILMENU
   add constraint FK_PERFILME_PERFILMEN_MENU foreign key (MENID)
      references MENU (MENID)
      on delete restrict on update restrict;

alter table PERFILMENU
   add constraint FK_PERFILME_PERFILMEN_PERFIL foreign key (PRFID)
      references PERFIL (PRFID)
      on delete restrict on update restrict;

alter table PRODUCTOR
   add constraint FK_PRODUCTO_USUARIOPR_USUARIO foreign key (USRID)
      references USUARIO (USRID)
      on delete restrict on update restrict;

alter table USUARIOPERFIL
   add constraint FK_USUARIOP_USUARIOPE_USUARIO foreign key (USRID)
      references USUARIO (USRID)
      on delete restrict on update restrict;

alter table USUARIOPERFIL
   add constraint FK_USUARIOP_USUARIOPE_PERFIL foreign key (PRFID)
      references PERFIL (PRFID)
      on delete restrict on update restrict;

