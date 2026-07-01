-- ============================================================
-- Seed de usuários mock
-- Executado automaticamente pelo Spring Boot ao inicializar
-- (src/main/resources/data.sql)
--
-- Cada INSERT só é executado se o CPF ainda não existir na tabela,
-- então é seguro rodar em todo restart da aplicação.
-- ============================================================

INSERT INTO TB_USUARIOS (nome, cpf, email, data_nascimento, senha, status)
SELECT 'Victor de Oliveira', '12345678901', 'victor@email.com', '1990-03-15', '123456', 'ATIVO'
WHERE NOT EXISTS (SELECT 1 FROM TB_USUARIOS WHERE cpf = '12345678901');

INSERT INTO TB_USUARIOS (nome, cpf, email, data_nascimento, senha, status)
SELECT 'Carlos Eduardo Souza', '23456789012', 'carlos.souza@email.com', '1988-07-22', '123456', 'ATIVO'
WHERE NOT EXISTS (SELECT 1 FROM TB_USUARIOS WHERE cpf = '23456789012');

INSERT INTO TB_USUARIOS (nome, cpf, email, data_nascimento, senha, status)
SELECT 'Fernanda Lima Costa', '34567890123', 'fernanda.lima@email.com', '1995-11-08', '123456', 'INATIVO'
WHERE NOT EXISTS (SELECT 1 FROM TB_USUARIOS WHERE cpf = '34567890123');

INSERT INTO TB_USUARIOS (nome, cpf, email, data_nascimento, senha, status)
SELECT 'Rafael Mendes Silva', '45678901234', 'rafael.mendes@email.com', '1992-01-30', '123456', 'ATIVO'
WHERE NOT EXISTS (SELECT 1 FROM TB_USUARIOS WHERE cpf = '45678901234');

INSERT INTO TB_USUARIOS (nome, cpf, email, data_nascimento, senha, status)
SELECT 'Juliana Alves Pereira', '56789012345', 'juliana.alves@email.com', '1998-05-19', '123456', 'ATIVO'
WHERE NOT EXISTS (SELECT 1 FROM TB_USUARIOS WHERE cpf = '56789012345');

INSERT INTO TB_USUARIOS (nome, cpf, email, data_nascimento, senha, status)
SELECT 'Bruno Henrique Rocha', '67890123456', 'bruno.rocha@email.com', '1985-09-27', '123456', 'INATIVO'
WHERE NOT EXISTS (SELECT 1 FROM TB_USUARIOS WHERE cpf = '67890123456');


-- ============================================================
-- Seed de projetos mock
-- OBS: usuario_resp_id assume que os usuarios seed acima geraram
-- IDs sequenciais de 1 a 5. Se a ordem de insercao for diferente,
-- ajuste os valores abaixo.
--
-- OBS 2: valores de status confirmados pelo enum StatusProjeto
-- (ATIVO, CONCLUIDO, CANCELADO).
-- ============================================================

INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_conclusao, status, usuario_resp_id)
SELECT 'Migração para Nuvem', 'Migração de sistema legado para arquitetura em nuvem.', '2026-01-10', '2026-03-20', 'CONCLUIDO', 1
WHERE NOT EXISTS (SELECT 1 FROM TB_PROJETOS WHERE nome = 'Migração para Nuvem');

INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_conclusao, status, usuario_resp_id)
SELECT 'Desenvolvimento Web', 'Desenvolvimento de web.', '2026-04-15', '2026-06-01', 'ATIVO', 4
WHERE NOT EXISTS (SELECT 1 FROM TB_PROJETOS WHERE nome = 'Desenvolvimento Web');

INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_conclusao, status, usuario_resp_id)
SELECT 'API de Pagamentos', 'Implementação de API de pagamentos com integração a gateway externo.', '2026-05-01', '2026-08-30', 'ATIVO', 2
WHERE NOT EXISTS (SELECT 1 FROM TB_PROJETOS WHERE nome = 'API de Pagamentos');

INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_conclusao, status, usuario_resp_id)
SELECT 'Refatoração de Autenticação', 'Refatoração do módulo de autenticação com JWT e Spring Security.', '2026-02-01', '2026-02-28', 'CANCELADO', 3
WHERE NOT EXISTS (SELECT 1 FROM TB_PROJETOS WHERE nome = 'Refatoração de Autenticação');

INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_conclusao, status, usuario_resp_id)
SELECT 'Dashboard de Relatórios', 'Criação de dashboard de relatórios gerenciais em React.', '2026-07-01', '2026-10-15', 'ATIVO', 5
WHERE NOT EXISTS (SELECT 1 FROM TB_PROJETOS WHERE nome = 'Dashboard de Relatórios');


-- ============================================================
-- Seed de tarefas mock
-- OBS: projeto_id e usuario_id assumem os IDs sequenciais gerados
-- pelos seeds de TB_PROJETOS e TB_USUARIOS acima (1 a 5).
-- Verificacao de duplicidade feita por titulo + projeto_id, ja que
-- titulo sozinho pode se repetir entre projetos diferentes.
-- ============================================================

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Levantamento de Requisitos', 'Levantamento de requisitos do módulo de migração.', '2026-01-10', '2026-01-20', 'MEDIA', 'EM_ANDAMENTO', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Levantamento de Requisitos' AND projeto_id = 1);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Revisão de Escopo do Projeto', 'Tarefa teste 01 atualizado', '2026-03-01', '2026-06-15', 'ALTA', 'PENDENTE', 1, 1
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Revisão de Escopo do Projeto' AND projeto_id = 1);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Configuração de Ambiente Cloud', 'Configuração do ambiente de nuvem e deploy inicial.', '2026-01-25', '2026-03-15', 'ALTA', 'CONCLUIDA', 1, 2
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Configuração de Ambiente Cloud' AND projeto_id = 1);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Criação das Telas Principais', 'Criação das telas principais do front-end web.', '2026-04-15', '2026-05-01', 'MEDIA', 'EM_ANDAMENTO', 2, 4
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Criação das Telas Principais' AND projeto_id = 2);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Integração Front-end com API', 'Integração do front-end com a API REST.', '2026-05-02', '2026-06-01', 'ALTA', 'PENDENTE', 2, 5
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Integração Front-end com API' AND projeto_id = 2);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Testes de Responsividade', 'Testes de responsividade e ajustes de layout.', '2026-05-20', '2026-06-01', 'BAIXA', 'PENDENTE', 2, 4
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Testes de Responsividade' AND projeto_id = 2);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Definição do Gateway de Pagamento', 'Estudo e definição do gateway de pagamento a ser utilizado.', '2026-05-01', '2026-05-15', 'ALTA', 'CONCLUIDA', 3, 2
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Definição do Gateway de Pagamento' AND projeto_id = 3);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Implementação do Checkout', 'Implementação do fluxo de checkout e webhook de confirmação.', '2026-05-16', '2026-07-30', 'ALTA', 'EM_ANDAMENTO', 3, 3
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Implementação do Checkout' AND projeto_id = 3);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Testes de Segurança de Transações', 'Testes de segurança e validação de transações.', '2026-08-01', '2026-08-30', 'MEDIA', 'PENDENTE', 3, 2
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Testes de Segurança de Transações' AND projeto_id = 3);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Mapeamento de Endpoints', 'Mapeamento dos endpoints afetados pela refatoração.', '2026-02-01', '2026-02-10', 'MEDIA', 'CONCLUIDA', 4, 3
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Mapeamento de Endpoints' AND projeto_id = 4);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Implementação de Autenticação JWT', 'Implementação do filtro JWT e configuração do Spring Security.', '2026-02-11', '2026-02-25', 'ALTA', 'CONCLUIDA', 4, 3
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Implementação de Autenticação JWT' AND projeto_id = 4);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, projeto_id, usuario_id)
SELECT 'Modelagem de Componentes do Dashboard', 'Modelagem dos componentes de gráficos do dashboard.', '2026-07-01', '2026-08-01', 'BAIXA', 'PENDENTE', 5, 5
WHERE NOT EXISTS (SELECT 1 FROM TB_TAREFAS WHERE titulo = 'Modelagem de Componentes do Dashboard' AND projeto_id = 5);