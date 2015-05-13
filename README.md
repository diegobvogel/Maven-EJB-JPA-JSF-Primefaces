# Maven-EJB-JPA-JSF-Primefaces
Projeto exemplo feito em Java junto com Maven, EJB, JPA, JSF e Primefaces.

Sou desenvolvedor Java Web a mais de 5 anos. Porém somente tive contato com frameworks pobres como XSLT, que somente lê o XML enviado pela Servlet e mostra na tela como se fosse HTML puro (não possui interfaces ricas). Por isso tenho bastante conhecimento em Javascript, CSS e Banco de dados (acessado via JDBC).
Fiz esse projeto com o objetivo de aprender algumas das tecnologias mais usadas no mercado...

O projeto consiste em uma tela inicial que possui um link e redireciona para uma tela de CRUD. Essa segunda tela faz o CRUD em uma tabela de Log (usu_tlogintegracao). Essa tabela já estava criada no banco de dados e eu só usei ela para esse exemplo. Ela possui relacionamento com outras duas tabelas (usu_tstatusintegracao e usu_ttipoarqintegracao), que servem apenas para carregar duas combos na tela pricipal.

O banco de dados utilizado para o desenvolvimento foi o Sql Server 2008.

Seguem os scripts de criação das tabelas:

<br/><br/><br/><br/><br/>



    -- TABELA USU_TTIPOSRQINTEGRACAO
    
    CREATE TABLE [dbo].[usu_ttipoarqIntegracao](
    	[Idtipoarqintegracao] [int] IDENTITY(1,1) NOT NULL,
    	[desctipoarqintegracao] [varchar](80) NULL,
    	[extensaoarqintegracao] [char](3) NULL,
    PRIMARY KEY CLUSTERED 
    (
    	[Idtipoarqintegracao] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON, FILLFACTOR = 95) ON [PRIMARY]
    ) ON [PRIMARY]
    
    GO
    
    SET ANSI_PADDING OFF
    GO
    
    
    
    -- TABELA USU_TSTATUSINTEGRACAO
    
    CREATE TABLE [dbo].[usu_tstatusintegracao](
    	[statusintegracao] [int] IDENTITY(1,1) NOT NULL,
    	[descstatusinteg] [varchar](30) NULL,
    PRIMARY KEY CLUSTERED 
    (
    	[statusintegracao] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON, FILLFACTOR = 95) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
    
    
    -- TABELA USU_TLOGINTEGRACAO
    
    CREATE TABLE [dbo].[usu_tlogintegracao](
    	[logintegracao] [int] IDENTITY(1,1) NOT NULL,
    	[statusintegracao] [int] NULL,
    	[desclogintegracao] [varchar](255) NULL,
    	[dataintegracao] [datetime] NULL,
    	[nmarquivointegracao] [varchar](80) NULL,
    	[numregistrointegracao] [int] NULL,
    	[Idtipoarqintegracao] [int] NULL,
    	[dtgeracaoarquivo] [datetime] NULL,
    	[identregistro] [varchar](255) NULL,
    	[desclogerrotecnico] [text] NULL,
     CONSTRAINT [PK__usu_tlog__0102233F48CFD27E] PRIMARY KEY CLUSTERED 
    (
    	[logintegracao] ASC
    )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON, FILLFACTOR = 95) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    
    GO
    
    ALTER TABLE [dbo].[usu_tlogintegracao]  WITH CHECK ADD  CONSTRAINT [FK_idstatusintegracao] FOREIGN KEY([statusintegracao])
    REFERENCES [dbo].[usu_tstatusintegracao] ([statusintegracao])
    GO
    
    ALTER TABLE [dbo].[usu_tlogintegracao] CHECK CONSTRAINT [FK_idstatusintegracao]
    GO
    
    ALTER TABLE [dbo].[usu_tlogintegracao]  WITH CHECK ADD  CONSTRAINT [FK_tipoarqintegracao] FOREIGN KEY([Idtipoarqintegracao])
    REFERENCES [dbo].[usu_ttipoarqIntegracao] ([Idtipoarqintegracao])
    GO
    
    ALTER TABLE [dbo].[usu_tlogintegracao] CHECK CONSTRAINT [FK_tipoarqintegracao]
    GO

