-- ISSUE 'authentication'

INSERT INTO tb_grupo_usuario (descricao, label) VALUES ('Administrador', 'ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO tb_grupo_usuario (descricao, label) VALUES ('Usuário', 'USER') ON CONFLICT DO NOTHING;
INSERT INTO tb_grupo_usuario (descricao, label) VALUES ('Convidado', 'GUEST') ON CONFLICT DO NOTHING;

INSERT INTO tb_permissao (label) VALUES ('ADICIONAR') ON CONFLICT DO NOTHING;
INSERT INTO tb_permissao (label) VALUES ('EDITAR') ON CONFLICT DO NOTHING;
INSERT INTO tb_permissao (label) VALUES ('EXCLUIR') ON CONFLICT DO NOTHING;
INSERT INTO tb_permissao (label) VALUES ('LER') ON CONFLICT DO NOTHING;

INSERT INTO tb_grupo_permissao (id_grupo, id_permissao) VALUES (
	(SELECT id FROM tb_grupo_usuario WHERE label = 'ADMIN'),
	(SELECT id FROM tb_permissao WHERE label = 'ADICIONAR')
) ON CONFLICT DO NOTHING;

INSERT INTO tb_grupo_permissao (id_grupo, id_permissao) VALUES (
	(SELECT id FROM tb_grupo_usuario WHERE label = 'ADMIN'),
	(SELECT id FROM tb_permissao WHERE label = 'EDITAR')
) ON CONFLICT DO NOTHING;

INSERT INTO tb_grupo_permissao (id_grupo, id_permissao) VALUES (
	(SELECT id FROM tb_grupo_usuario WHERE label = 'ADMIN'),
	(SELECT id FROM tb_permissao WHERE label = 'EXCLUIR')
) ON CONFLICT DO NOTHING;

INSERT INTO tb_grupo_permissao (id_grupo, id_permissao) VALUES (
	(SELECT id FROM tb_grupo_usuario WHERE label = 'ADMIN'),
	(SELECT id FROM tb_permissao WHERE label = 'LER')
) ON CONFLICT DO NOTHING;

INSERT INTO tb_grupo_permissao (id_grupo, id_permissao) VALUES (
	(SELECT id FROM tb_grupo_usuario WHERE label = 'USER'),
	(SELECT id FROM tb_permissao WHERE label = 'ADICIONAR')
) ON CONFLICT DO NOTHING;

INSERT INTO tb_grupo_permissao (id_grupo, id_permissao) VALUES (
	(SELECT id FROM tb_grupo_usuario WHERE label = 'USER'),
	(SELECT id FROM tb_permissao WHERE label = 'LER')
) ON CONFLICT DO NOTHING;

-- Note: password value is '123' (without apostrophes) encrypted.

INSERT INTO tb_usuario (usuario, senha, apelido, is_ativo, id_grupo_usuario) VALUES
	('admin', '$2a$10$8IjRCxtmyWqkgMntUZWRW.FsEu0r6WuVtVC9Sg9j.Np/zne2M050.', 'Administrador', TRUE,
	(SELECT id FROM tb_grupo_usuario WHERE descricao = 'Administrador')
) ON CONFLICT DO NOTHING;

INSERT INTO tb_usuario (usuario, senha, apelido, is_ativo, id_grupo_usuario) VALUES
	('user', '$2a$10$8IjRCxtmyWqkgMntUZWRW.FsEu0r6WuVtVC9Sg9j.Np/zne2M050.', 'Usuário', TRUE,
	(SELECT id FROM tb_grupo_usuario WHERE descricao = 'Usuário')
) ON CONFLICT DO NOTHING;

INSERT INTO tb_usuario (usuario, senha, apelido, is_ativo, id_grupo_usuario) VALUES
	('convidado', '$2a$10$8IjRCxtmyWqkgMntUZWRW.FsEu0r6WuVtVC9Sg9j.Np/zne2M050.', 'Convidado', TRUE,
	(SELECT id FROM tb_grupo_usuario WHERE descricao = 'Convidado')
) ON CONFLICT DO NOTHING;
