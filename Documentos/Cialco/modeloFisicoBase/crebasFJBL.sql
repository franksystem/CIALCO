/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     23/04/2016 9:43:52                           */
/*==============================================================*/


drop index INDEX_4;

drop table CANASTA_TBL;

drop index INDEX_2;

drop table CANTON_TBL;

drop index INDEX_TIPOCATALOGO;

drop table CATALOGO_TBL;

drop index INDEX_7;

drop table CIALCO_TBL;

drop table CONTRATO_TBL;

drop table DESTINOINGRESO_TBL;

drop table DESTINOPRODUCCION_TBL;

drop index INDEX_5;

drop table ENTREGACANASTA_TBL;

drop table FUENTEINGRESO_TBL;

drop table INSTITUCIONAPOYO_TBL;

drop index INDEX_6;

drop table LUGARENTREGACANASTA_TBL;

drop index INDEX_8;

drop table MENU_TBL;

drop table ORGANIZACION_TBL;

drop table PANTALLA_TBL;

drop index INDEX_3;

drop table PARROQUIA_TBL;

drop index INDEX_9;

drop table PERFIL_TBL;

drop table PERSONASXCIALCO_TBL;

drop index CEDULAPERSONA;

drop table PERSONA_TBL;

drop table PRACTICAPRODUCTIVA_TBL;

drop index INDEX_1;

drop table PRESENTACIONPRODUCTO_TBL;

drop index INDEX_IDPRODUCTORO;

drop table PRODUCTORXORGANIZACION_TBL;

drop table PRODUCTOR_TBL;

drop index INDEX_IDPROCIALCO;

drop index INDEX_IDCIALCO;

drop table PRODUCTOXCIALCO_TBL;

drop index INDEX_IDPRODUCTOR;

drop table PRODUCTOXPRODUCTOR_TBL;

drop table PROVEEDOR_TBL;

drop table PROVINCIA_TBL;

drop table UBICACIONFINCA_TBL;

drop table USUARIOPERFIL_TBL;

drop index INDEX_NOMBREUSUARIO;

drop table USUARIO_TBL;

/*==============================================================*/
/* Table: CANASTA_TBL                                           */
/*==============================================================*/
create table CANASTA_TBL (
   ID_CANASTA           INT8                 not null,
   ID_CIALCO            INT8                 null,
   ID_CATALOGOTIPOCANASTA INT4                 null,
   PRECIOCANASTA        DECIMAL              null,
   ESTADO               INT2                 null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_CANASTA_TBL primary key (ID_CANASTA)
);

/*==============================================================*/
/* Index: INDEX_4                                               */
/*==============================================================*/
create  index INDEX_4 on CANASTA_TBL (
ID_CIALCO
);

/*==============================================================*/
/* Table: CANTON_TBL                                            */
/*==============================================================*/
create table CANTON_TBL (
   ID_CANTON            INT4                 not null,
   ID_PROVINCIA         INT4                 null,
   NOMBRECANTON         VARCHAR(100)         null,
   constraint PK_CANTON_TBL primary key (ID_CANTON)
);

/*==============================================================*/
/* Index: INDEX_2                                               */
/*==============================================================*/
create  index INDEX_2 on CANTON_TBL (
ID_PROVINCIA
);

/*==============================================================*/
/* Table: CATALOGO_TBL                                          */
/*==============================================================*/
create table CATALOGO_TBL (
   ID_CATALOGO          INT4                 not null,
   TIPOCATALOGO         INT4                 not null,
   ELEMENTOCATALOGO     CHAR(100)            not null,
   DESCRIPCIONCATALOGO  CHAR(100)            null,
   ID_CATALOGOPADRE     INT4                 null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_CATALOGO_TBL primary key (ID_CATALOGO)
);

/*==============================================================*/
/* Index: INDEX_TIPOCATALOGO                                    */
/*==============================================================*/
create  index INDEX_TIPOCATALOGO on CATALOGO_TBL (
TIPOCATALOGO
);

/*==============================================================*/
/* Table: CIALCO_TBL                                            */
/*==============================================================*/
create table CIALCO_TBL (
   ID_CIALCO            INT8                 not null,
   NOMBRECIALCO         VARCHAR(100)         null,
   NOMBREREPRESENTANTECIALCO VARCHAR(100)         null,
   TELEFONOFIJO         CHAR(20)             null,
   TELEFONOMOVIL        CHAR(20)             null,
   NOMBREORGANIZACION   VARCHAR(200)         null,
   ID_CATALOGOFRECUENCIA INT4                 null,
   ID_PROVINCIA         INT4                 null,
   ID_CANTON            INT4                 null,
   ID_PARROQUIA         INT4                 null,
   COORDENADAX          INT8                 null,
   COORDENADAY          INT8                 null,
   COORDENADAZ          INT8                 null,
   LOCALIDAD            CHAR(50)             null,
   CORREO               CHAR(20)             null,
   ID_CATALOGODIAS      CHAR(20)             null,
   TIPO                 INT4                 not null,
   FECHAINICIO          TIME                 null,
   FECHAFIN             TIME                 null,
   MONTOCOMPRAS         DECIMAL              null,
   MONTOVENTAS          DECIMAL              null,
   constraint PK_CIALCO_TBL primary key (ID_CIALCO)
);

/*==============================================================*/
/* Index: INDEX_7                                               */
/*==============================================================*/
create unique index INDEX_7 on CIALCO_TBL (
ID_CIALCO
);

/*==============================================================*/
/* Table: CONTRATO_TBL                                          */
/*==============================================================*/
create table CONTRATO_TBL (
   ID_CONTRATO          INT8                 not null,
   ID_CIALCO            INT8                 null,
   ENTIDAD              CHAR(200)            null,
   ESTADO               INT2                 null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFIACION     TIMESTAMP            null,
   constraint PK_CONTRATO_TBL primary key (ID_CONTRATO)
);

comment on table CONTRATO_TBL is
'aqui ubiamos los contratos y las entidadesdel cialco de compra publica';

/*==============================================================*/
/* Table: DESTINOINGRESO_TBL                                    */
/*==============================================================*/
create table DESTINOINGRESO_TBL (
   ID_DESTINOINGRESO    INT8                 not null,
   ID_PRODUCTOR         INT8                 null,
   ID_CATALOGODESTINO   INT4                 null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_DESTINOINGRESO_TBL primary key (ID_DESTINOINGRESO)
);

/*==============================================================*/
/* Table: DESTINOPRODUCCION_TBL                                 */
/*==============================================================*/
create table DESTINOPRODUCCION_TBL (
   ID_DESTINOPRODUCCION INT8                 not null,
   ID_CIALCO            INT8                 null,
   ID_PRODUCTOR         INT8                 null,
   ID_CATALOGOTIPODESTINO INT4                 null,
   ESTADO               INT8                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_DESTINOPRODUCCION_TBL primary key (ID_DESTINOPRODUCCION)
);

/*==============================================================*/
/* Table: ENTREGACANASTA_TBL                                    */
/*==============================================================*/
create table ENTREGACANASTA_TBL (
   ID_ENTREGACANASTA    INT8                 not null,
   ID_CANASTA           INT8                 null,
   ID_CATALOGOTIPOENTREGA INT2                 null,
   ESTADO               INT2                 null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_ENTREGACANASTA_TBL primary key (ID_ENTREGACANASTA)
);

/*==============================================================*/
/* Index: INDEX_5                                               */
/*==============================================================*/
create  index INDEX_5 on ENTREGACANASTA_TBL (
ID_CANASTA
);

/*==============================================================*/
/* Table: FUENTEINGRESO_TBL                                     */
/*==============================================================*/
create table FUENTEINGRESO_TBL (
   ID_FUENTEINGRESO     INT8                 not null,
   ID_PRODUCTOR         INT8                 null,
   ID_CATALOGOTIPOFUENTE INT4                 null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_FUENTEINGRESO_TBL primary key (ID_FUENTEINGRESO)
);

/*==============================================================*/
/* Table: INSTITUCIONAPOYO_TBL                                  */
/*==============================================================*/
create table INSTITUCIONAPOYO_TBL (
   ID_INSTITUCIONAPOYO  INT8                 not null,
   ID_PRODUCTOR         INT8                 null,
   TIPOAPOYO            VARCHAR(200)         null,
   NOMBREINSTITUCIONAPOYO VARCHAR(200)         null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_INSTITUCIONAPOYO_TBL primary key (ID_INSTITUCIONAPOYO)
);

/*==============================================================*/
/* Table: LUGARENTREGACANASTA_TBL                               */
/*==============================================================*/
create table LUGARENTREGACANASTA_TBL (
   ID_LUGARENTREGA      INT8                 not null,
   ID_ENTREGACANASTA    INT8                 null,
   ID_CATALOGOFRECUENCIA INT2                 null,
   ID_CATALOGODIAS      CHAR(20)             null,
   LUGAR                CHAR(100)            null,
   ESTADO               INT2                 null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_LUGARENTREGACANASTA_TBL primary key (ID_LUGARENTREGA)
);

/*==============================================================*/
/* Index: INDEX_6                                               */
/*==============================================================*/
create  index INDEX_6 on LUGARENTREGACANASTA_TBL (
ID_ENTREGACANASTA
);

/*==============================================================*/
/* Table: MENU_TBL                                              */
/*==============================================================*/
create table MENU_TBL (
   ID_MENU              INT8                 not null,
   ID_PANTALLA          INT8                 null,
   ID_MENUPADRE         INT8                 null,
   NOMBRE               VARCHAR(100)         not null,
   ICONO                VARCHAR(20)          null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   ESTADO               INT2                 null,
   constraint PK_MENU_TBL primary key (ID_MENU)
);

/*==============================================================*/
/* Index: INDEX_8                                               */
/*==============================================================*/
create unique index INDEX_8 on MENU_TBL (
ID_MENU
);

/*==============================================================*/
/* Table: ORGANIZACION_TBL                                      */
/*==============================================================*/
create table ORGANIZACION_TBL (
   ID_ORGANIZACION      INT8                 not null,
   ID_PRODUCTOR         INT8                 null,
   RUC                  INT8                 null,
   NOMBREORGANIZACION   VARCHAR(100)         null,
   NOMBREREPRESENTANTE  VARCHAR(100)         null,
   TELEFONOREPRESENTANTE CHAR(20)             null,
   MAILREPRESENTANTE    VARCHAR(200)         null,
   NOMBRECONTACTO       VARCHAR(100)         null,
   TELEFONOCONTACTO     CHAR(20)             null,
   MAILCONTACTO         VARCHAR(100)         null,
   NUMERODSOCIOS        INT2                 null,
   ID_CATALOGOGRADO     INT4                 null,
   FECHASEPS            TIMESTAMP            null,
   CODIGOSEPS           VARCHAR(50)          null,
   FECHAMAGAP           TIMESTAMP            null,
   CODIGOMAGAP          VARCHAR(50)          null,
   SUPERFICIEORG        FLOAT8               null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_ORGANIZACION_TBL primary key (ID_ORGANIZACION)
);

/*==============================================================*/
/* Table: PANTALLA_TBL                                          */
/*==============================================================*/
create table PANTALLA_TBL (
   ID_PANTALLA          INT8                 not null,
   URL                  VARCHAR(100)         not null,
   NOMBREPANTALLA       VARCHAR(200)         null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   ESTADO               INT2                 null,
   constraint PK_PANTALLA_TBL primary key (ID_PANTALLA)
);

/*==============================================================*/
/* Table: PARROQUIA_TBL                                         */
/*==============================================================*/
create table PARROQUIA_TBL (
   ID_PARROQUIA         INT4                 not null,
   ID_CANTON            INT4                 null,
   NOMBREPARROQUIA      VARCHAR(100)         null,
   constraint PK_PARROQUIA_TBL primary key (ID_PARROQUIA)
);

/*==============================================================*/
/* Index: INDEX_3                                               */
/*==============================================================*/
create  index INDEX_3 on PARROQUIA_TBL (
ID_CANTON
);

/*==============================================================*/
/* Table: PERFIL_TBL                                            */
/*==============================================================*/
create table PERFIL_TBL (
   ID_PERFIL            INT8                 not null,
   ID_MENU              INT8                 null,
   NOMBREPERFIL         CHAR(100)            not null,
   DESCRIPCIONPERFIL    CHAR(100)            not null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   ESTADO               INT2                 not null,
   constraint PK_PERFIL_TBL primary key (ID_PERFIL)
);

/*==============================================================*/
/* Index: INDEX_9                                               */
/*==============================================================*/
create unique index INDEX_9 on PERFIL_TBL (
ID_PERFIL
);

/*==============================================================*/
/* Table: PERSONASXCIALCO_TBL                                   */
/*==============================================================*/
create table PERSONASXCIALCO_TBL (
   ID_PERSONACIALCO     INT8                 not null,
   ID_CIALCO            INT8                 null,
   ID_PERSONA           INT8                 null,
   constraint PK_PERSONASXCIALCO_TBL primary key (ID_PERSONACIALCO)
);

/*==============================================================*/
/* Table: PERSONA_TBL                                           */
/*==============================================================*/
create table PERSONA_TBL (
   ID_PERSONA           INT8                 not null,
   NOMBREPERSONA        VARCHAR(100)         not null,
   APELLIDOPERSONA      VARCHAR(100)         not null,
   CEDULAPERSONA        INT8                 not null,
   EDADPERSONA          INT2                 null,
   MAILPERSONA          VARCHAR(100)         null,
   ACTIVIDADPERSONA     VARCHAR(200)         null,
   ID_CATALOGOESCOLARIDAD INT4                 not null,
   ID_CATALOGOETNIA     INT4                 not null,
   ID_CATALOGOGENERO    INT4                 not null,
   TELEFONOFIJO         CHAR(20)             null,
   TELEFONOMOVIL        CHAR(20)             null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   ID_CATALOGOPARENTESCO INT4                 null,
   constraint PK_PERSONA_TBL primary key (ID_PERSONA)
);

/*==============================================================*/
/* Index: CEDULAPERSONA                                         */
/*==============================================================*/
create unique index CEDULAPERSONA on PERSONA_TBL (
CEDULAPERSONA
);

/*==============================================================*/
/* Table: PRACTICAPRODUCTIVA_TBL                                */
/*==============================================================*/
create table PRACTICAPRODUCTIVA_TBL (
   ID_PRACTICAPRODUCTIVA INT8                 not null,
   ID_PRODUCTOR         INT8                 not null,
   ID_CATALOGOPRACTICAPRODUCTIVA INT4                 not null,
   ID_CATALOGOCERTIFICACION INT4                 null,
   ID_CATALOGOCERTIFICADORA INT4                 null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_PRACTICAPRODUCTIVA_TBL primary key (ID_PRACTICAPRODUCTIVA)
);

/*==============================================================*/
/* Table: PRESENTACIONPRODUCTO_TBL                              */
/*==============================================================*/
create table PRESENTACIONPRODUCTO_TBL (
   ID_PRESENTACION      INT8                 not null,
   ID_CIALCO            INT8                 null,
   ID_CATALOGOPRODUCTO  INT4                 null,
   CANTIDAD             INT4                 null,
   ID_CATALOGOUNIDAD    INT4                 null,
   PRECIO               DECIMAL              null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   MONTOMES             DECIMAL              null,
   constraint PK_PRESENTACIONPRODUCTO_TBL primary key (ID_PRESENTACION)
);

/*==============================================================*/
/* Index: INDEX_1                                               */
/*==============================================================*/
create  index INDEX_1 on PRESENTACIONPRODUCTO_TBL (
ID_CIALCO
);

/*==============================================================*/
/* Table: PRODUCTORXORGANIZACION_TBL                            */
/*==============================================================*/
create table PRODUCTORXORGANIZACION_TBL (
   ID_PRODUCTORORG      INT8                 not null,
   ID_PRODUCTOR         INT8                 not null,
   ID_ORGANIZACION      INT8                 not null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_PRODUCTORXORGANIZACION_TBL primary key (ID_PRODUCTORORG)
);

/*==============================================================*/
/* Index: INDEX_IDPRODUCTORO                                    */
/*==============================================================*/
create  index INDEX_IDPRODUCTORO on PRODUCTORXORGANIZACION_TBL (
ID_PRODUCTOR
);

/*==============================================================*/
/* Table: PRODUCTOR_TBL                                         */
/*==============================================================*/
create table PRODUCTOR_TBL (
   ID_PRODUCTOR         INT8                 not null,
   ID_PERSONA           INT8                 null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_PRODUCTOR_TBL primary key (ID_PRODUCTOR)
);

/*==============================================================*/
/* Table: PRODUCTOXCIALCO_TBL                                   */
/*==============================================================*/
create table PRODUCTOXCIALCO_TBL (
   ID_PROCIAL           INT8                 not null,
   ID_CIALCO            INT8                 null,
   ID_CATALOGOPRODUCTO  INT2                 null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_PRODUCTOXCIALCO_TBL primary key (ID_PROCIAL)
);

/*==============================================================*/
/* Index: INDEX_IDCIALCO                                        */
/*==============================================================*/
create  index INDEX_IDCIALCO on PRODUCTOXCIALCO_TBL (
ID_CIALCO
);

/*==============================================================*/
/* Index: INDEX_IDPROCIALCO                                     */
/*==============================================================*/
create  index INDEX_IDPROCIALCO on PRODUCTOXCIALCO_TBL (
ID_CIALCO
);

/*==============================================================*/
/* Table: PRODUCTOXPRODUCTOR_TBL                                */
/*==============================================================*/
create table PRODUCTOXPRODUCTOR_TBL (
   ID_PRODUCTPRO        INT8                 not null,
   ID_PRODUCTOR         INT8                 not null,
   ID_CATALOGOPRODUCTO  INT4                 not null,
   ID_CATALOGOTIPOPRO   INT4                 null,
   ID_CATALOGORUBROPRO  INT4                 null,
   ID_CATALOGOUNIDAD    INT4                 null,
   TIPO                 INT2                 null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_PRODUCTOXPRODUCTOR_TBL primary key (ID_PRODUCTPRO)
);

/*==============================================================*/
/* Index: INDEX_IDPRODUCTOR                                     */
/*==============================================================*/
create  index INDEX_IDPRODUCTOR on PRODUCTOXPRODUCTOR_TBL (
ID_PRODUCTOR
);

/*==============================================================*/
/* Table: PROVEEDOR_TBL                                         */
/*==============================================================*/
create table PROVEEDOR_TBL (
   ID_PROVEEDOR         FLOAT8               not null,
   ID_CIALCO            INT8                 null,
   NOMBREPROVEEDOR      CHAR(50)             null,
   TELEFONOFIJO         CHAR(15)             null,
   TELEFONOMOVIL        CHAR(15)             null,
   ID_CATALOGORUBROS    CHAR(20)             null,
   CORREO               CHAR(20)             null,
   ESTADO               INT2                 null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_PROVEEDOR_TBL primary key (ID_PROVEEDOR)
);

/*==============================================================*/
/* Table: PROVINCIA_TBL                                         */
/*==============================================================*/
create table PROVINCIA_TBL (
   ID_PROVINCIA         INT4                 not null,
   NOMBREPROVINCIA      VARCHAR(200)         null,
   constraint PK_PROVINCIA_TBL primary key (ID_PROVINCIA)
);

/*==============================================================*/
/* Table: UBICACIONFINCA_TBL                                    */
/*==============================================================*/
create table UBICACIONFINCA_TBL (
   ID_UBICACIONFINCA    INT8                 not null,
   ID_PRODUCTOR         INT8                 null,
   ID_PROVINCIA         INT4                 null,
   ID_CANTON            INT4                 null,
   ID_PARROQUIA         INT4                 null,
   COORDENADAX          INT8                 null,
   COORDENADAY          INT8                 null,
   COORDENADAZ          INT8                 null,
   LOCALIDADFINCA       VARCHAR(200)         null,
   SUPERFICIEFINCA      DECIMAL              null,
   ID_CATALOGOPOSESION  INT4                 null,
   OTRA                 CHAR(100)            null,
   ESTADO               INT2                 not null,
   ID_USUARIOCREACION   INT8                 not null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   constraint PK_UBICACIONFINCA_TBL primary key (ID_UBICACIONFINCA)
);

/*==============================================================*/
/* Table: USUARIOPERFIL_TBL                                     */
/*==============================================================*/
create table USUARIOPERFIL_TBL (
   ID_USUARIOPERFIL     INT8                 not null,
   ID_PERFIL            INT8                 not null,
   ID_USUARIO           INT8                 not null,
   FECHACADUCIDAD       TIMESTAMP            null,
   CREARPERMISO         BOOL                 null,
   EDITARPERMISO        BOOL                 null,
   CONSULTAPERMISO      BOOL                 null,
   ELIMINARPERMISO      BOOL                 null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   ESTADO               INT2                 null,
   constraint PK_USUARIOPERFIL_TBL primary key (ID_USUARIOPERFIL)
);

/*==============================================================*/
/* Table: USUARIO_TBL                                           */
/*==============================================================*/
create table USUARIO_TBL (
   ID_USUARIO           INT8                 not null,
   ID_PERSONA           INT8                 null,
   NOMBREUSUARIO        CHAR(15)             not null,
   CONTRASENA           CHAR(100)            not null,
   ID_USUARIOCREACION   INT8                 null,
   FECHACREACION        TIMESTAMP            not null,
   ID_USUARIOMODIFICACION INT8                 null,
   FECHAMODIFICACION    TIMESTAMP            null,
   ESTADO               INT2                 not null,
   constraint PK_USUARIO_TBL primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: INDEX_NOMBREUSUARIO                                   */
/*==============================================================*/
create unique index INDEX_NOMBREUSUARIO on USUARIO_TBL (
NOMBREUSUARIO
);

alter table CANASTA_TBL
   add constraint FK_CANASTA__REFERENCE_CIALCO_T foreign key (ID_CIALCO)
      references CIALCO_TBL (ID_CIALCO)
      on delete restrict on update restrict;

alter table CANTON_TBL
   add constraint FK_CANTON_T_REFERENCE_PROVINCI foreign key (ID_PROVINCIA)
      references PROVINCIA_TBL (ID_PROVINCIA)
      on delete restrict on update restrict;

alter table CATALOGO_TBL
   add constraint FK_CATALOGO_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table CIALCO_TBL
   add constraint FK_CIALCO_T_REFERENCE_CATALOGO foreign key (ID_CATALOGOFRECUENCIA)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table CIALCO_TBL
   add constraint FK_CIALCO_T_REFERENCE_PROVINCI foreign key (ID_PROVINCIA)
      references PROVINCIA_TBL (ID_PROVINCIA)
      on delete restrict on update restrict;

alter table CIALCO_TBL
   add constraint FK_CIALCO_T_REFERENCE_CANTON_T foreign key (ID_CANTON)
      references CANTON_TBL (ID_CANTON)
      on delete restrict on update restrict;

alter table CIALCO_TBL
   add constraint FK_CIALCO_T_REFERENCE_PARROQUI foreign key (ID_PARROQUIA)
      references PARROQUIA_TBL (ID_PARROQUIA)
      on delete restrict on update restrict;

alter table CONTRATO_TBL
   add constraint FK_CONTRATO_REFERENCE_CIALCO_T foreign key (ID_CIALCO)
      references CIALCO_TBL (ID_CIALCO)
      on delete restrict on update restrict;

alter table DESTINOINGRESO_TBL
   add constraint FK_DESTINOI_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table DESTINOINGRESO_TBL
   add constraint FK_DESTINOI_REFERENCE_CATALOGO foreign key (ID_CATALOGODESTINO)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table DESTINOINGRESO_TBL
   add constraint FK_DESTINOI_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table DESTINOPRODUCCION_TBL
   add constraint FK_DESTINOP_REFERENCE_CATALOGO foreign key (ID_CATALOGOTIPODESTINO)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table DESTINOPRODUCCION_TBL
   add constraint FK_DESTINOP_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table DESTINOPRODUCCION_TBL
   add constraint FK_DESTINOP_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table DESTINOPRODUCCION_TBL
   add constraint FK_DESTINOP_REFERENCE_CIALCO_T foreign key (ID_CIALCO)
      references CIALCO_TBL (ID_CIALCO)
      on delete restrict on update restrict;

alter table ENTREGACANASTA_TBL
   add constraint FK_ENTREGAC_REFERENCE_CANASTA_ foreign key (ID_CANASTA)
      references CANASTA_TBL (ID_CANASTA)
      on delete restrict on update restrict;

alter table FUENTEINGRESO_TBL
   add constraint FK_FUENTEIN_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table FUENTEINGRESO_TBL
   add constraint FK_FUENTEIN_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table FUENTEINGRESO_TBL
   add constraint FK_FUENTEIN_REFERENCE_CATALOGO foreign key (ID_CATALOGOTIPOFUENTE)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table INSTITUCIONAPOYO_TBL
   add constraint FK_INSTITUC_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table INSTITUCIONAPOYO_TBL
   add constraint FK_INSTITUC_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table LUGARENTREGACANASTA_TBL
   add constraint FK_LUGARENT_REFERENCE_ENTREGAC foreign key (ID_ENTREGACANASTA)
      references ENTREGACANASTA_TBL (ID_ENTREGACANASTA)
      on delete restrict on update restrict;

alter table MENU_TBL
   add constraint FK_MENU_TBL_REFERENCE_PANTALLA foreign key (ID_PANTALLA)
      references PANTALLA_TBL (ID_PANTALLA)
      on delete restrict on update restrict;

alter table ORGANIZACION_TBL
   add constraint FK_ORGANIZA_REFERENCE_CATALOGO foreign key (ID_CATALOGOGRADO)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table ORGANIZACION_TBL
   add constraint FK_ORGANIZA_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table ORGANIZACION_TBL
   add constraint FK_ORGANIZA_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table PARROQUIA_TBL
   add constraint FK_PARROQUI_REFERENCE_CANTON_T foreign key (ID_CANTON)
      references CANTON_TBL (ID_CANTON)
      on delete restrict on update restrict;

alter table PERFIL_TBL
   add constraint FK_PERFIL_T_REFERENCE_MENU_TBL foreign key (ID_MENU)
      references MENU_TBL (ID_MENU)
      on delete restrict on update restrict;

alter table PERSONASXCIALCO_TBL
   add constraint FK_PERSONAS_REFERENCE_CIALCO_T foreign key (ID_CIALCO)
      references CIALCO_TBL (ID_CIALCO)
      on delete restrict on update restrict;

alter table PERSONASXCIALCO_TBL
   add constraint FK_PERSONAS_REFERENCE_PERSONA_ foreign key (ID_PERSONA)
      references PERSONA_TBL (ID_PERSONA)
      on delete restrict on update restrict;

alter table PERSONA_TBL
   add constraint FK_PERSONA__REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table PRACTICAPRODUCTIVA_TBL
   add constraint FK_PRACTICA_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table PRESENTACIONPRODUCTO_TBL
   add constraint FK_PRESENTA_REFERENCE_CIALCO_T foreign key (ID_CIALCO)
      references CIALCO_TBL (ID_CIALCO)
      on delete restrict on update restrict;

alter table PRODUCTORXORGANIZACION_TBL
   add constraint FK_PRODUCTO_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table PRODUCTORXORGANIZACION_TBL
   add constraint FK_PRODUCTO_REFERENCE_ORGANIZA foreign key (ID_ORGANIZACION)
      references ORGANIZACION_TBL (ID_ORGANIZACION)
      on delete restrict on update restrict;

alter table PRODUCTORXORGANIZACION_TBL
   add constraint FK_PRODUCTO_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table PRODUCTOR_TBL
   add constraint FK_PRODUCTO_REFERENCE_PERSONA_ foreign key (ID_PERSONA)
      references PERSONA_TBL (ID_PERSONA)
      on delete restrict on update restrict;

alter table PRODUCTOXCIALCO_TBL
   add constraint FK_PRODUCTO_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table PRODUCTOXCIALCO_TBL
   add constraint FK_PRODUCTO_REFERENCE_CATALOGO foreign key (ID_CATALOGOPRODUCTO)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table PRODUCTOXCIALCO_TBL
   add constraint FK_PRODUCTO_REFERENCE_CIALCO_T foreign key (ID_CIALCO)
      references CIALCO_TBL (ID_CIALCO)
      on delete restrict on update restrict;

alter table PRODUCTOXPRODUCTOR_TBL
   add constraint FK_PRODUCTO_REFERENCE_USUARIO_ foreign key (ID_USUARIOCREACION)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table PRODUCTOXPRODUCTOR_TBL
   add constraint FK_PRODUCTO_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table PRODUCTOXPRODUCTOR_TBL
   add constraint FK_PRODUCTO_REFERENCE_CATALOGO foreign key (ID_CATALOGOPRODUCTO)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table PROVEEDOR_TBL
   add constraint FK_PROVEEDO_REFERENCE_CIALCO_T foreign key (ID_CIALCO)
      references CIALCO_TBL (ID_CIALCO)
      on delete restrict on update restrict;

alter table UBICACIONFINCA_TBL
   add constraint FK_UBICACIO_REFERENCE_PROVINCI foreign key (ID_PROVINCIA)
      references PROVINCIA_TBL (ID_PROVINCIA)
      on delete restrict on update restrict;

alter table UBICACIONFINCA_TBL
   add constraint FK_UBICACIO_REFERENCE_CANTON_T foreign key (ID_CANTON)
      references CANTON_TBL (ID_CANTON)
      on delete restrict on update restrict;

alter table UBICACIONFINCA_TBL
   add constraint FK_UBICACIO_REFERENCE_PARROQUI foreign key (ID_PARROQUIA)
      references PARROQUIA_TBL (ID_PARROQUIA)
      on delete restrict on update restrict;

alter table UBICACIONFINCA_TBL
   add constraint FK_UBICACIO_REFERENCE_CATALOGO foreign key (ID_CATALOGOPOSESION)
      references CATALOGO_TBL (ID_CATALOGO)
      on delete restrict on update restrict;

alter table UBICACIONFINCA_TBL
   add constraint FK_UBICACIO_REFERENCE_PRODUCTO foreign key (ID_PRODUCTOR)
      references PRODUCTOR_TBL (ID_PRODUCTOR)
      on delete restrict on update restrict;

alter table USUARIOPERFIL_TBL
   add constraint FK_USUARIOP_REFERENCE_PERFIL_T foreign key (ID_PERFIL)
      references PERFIL_TBL (ID_PERFIL)
      on delete restrict on update restrict;

alter table USUARIOPERFIL_TBL
   add constraint FK_USUARIOP_REFERENCE_USUARIO_ foreign key (ID_USUARIO)
      references USUARIO_TBL (ID_USUARIO)
      on delete restrict on update restrict;

alter table USUARIO_TBL
   add constraint FK_USUARIO__REFERENCE_PERSONA_ foreign key (ID_PERSONA)
      references PERSONA_TBL (ID_PERSONA)
      on delete restrict on update restrict;

