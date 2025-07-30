# Requisitos Funcionais - Sistema Cultura em Pauta

## Visão Geral
Este documento define os requisitos funcionais do sistema "Cultura em Pauta", uma aplicação para gerenciamento de sessões de conselho cultural, permitindo o cadastro de pessoas, criação de propostas culturais, gestão de sessões e sistema de votação.

## RF001 - Gestão de Pessoas

### RF001.1 - Cadastrar Conselheiro
**Descrição**: O sistema deve permitir o cadastro de conselheiros com dados pessoais e profissionais.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar nome, CPF, email, telefone, PCD, raça, renda, ocupação profissional
- Sistema deve solicitar dados da carreira cultural (atuação, segmento, grupo)
- Sistema deve validar formato do CPF
- Sistema deve validar formato do email
- Sistema deve criar instância de Conselheiro
- Sistema deve adicionar conselheiro à lista de pessoas e votantes
- Sistema deve confirmar cadastro com mensagem de sucesso

### RF001.2 - Cadastrar Ouvinte
**Descrição**: O sistema deve permitir o cadastro de ouvintes com dados pessoais e profissionais.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar nome, CPF, email, telefone, PCD, raça, renda, ocupação profissional
- Sistema deve solicitar dados da carreira cultural (atuação, segmento, grupo)
- Sistema deve validar formato do CPF
- Sistema deve validar formato do email
- Sistema deve criar instância de Ouvinte
- Sistema deve adicionar ouvinte à lista de pessoas
- Sistema deve confirmar cadastro com mensagem de sucesso

### RF001.3 - Listar Conselheiros
**Descrição**: O sistema deve exibir lista de todos os conselheiros cadastrados.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve buscar todas as pessoas do tipo Conselheiro
- Sistema deve exibir nome e segmento cultural de cada conselheiro
- Sistema deve apresentar lista formatada

### RF001.4 - Listar Ouvintes
**Descrição**: O sistema deve exibir lista de todos os ouvintes cadastrados.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve buscar todas as pessoas do tipo Ouvinte
- Sistema deve exibir nome e segmento cultural de cada ouvinte
- Sistema deve apresentar lista formatada

### RF001.5 - Listar Pessoas Cadastradas
**Descrição**: O sistema deve exibir lista consolidada de todas as pessoas cadastradas.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve buscar todas as pessoas cadastradas (conselheiros e ouvintes)
- Sistema deve exibir nome e segmento cultural de cada pessoa
- Sistema deve apresentar lista consolidada formatada

### RF001.6 - Buscar Pessoa por CPF
**Descrição**: O sistema deve permitir buscar pessoa específica pelo CPF.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve solicitar CPF
- Sistema deve validar formato do CPF
- Sistema deve buscar pessoa no banco de dados
- Sistema deve exibir dados completos da pessoa encontrada
- Sistema deve informar quando pessoa não for encontrada

### RF001.7 - Remover Pessoa por CPF
**Descrição**: O sistema deve permitir remover pessoa cadastrada pelo CPF.  
**Prioridade**: Baixa  
**Critérios de Aceitação**:
- Sistema deve solicitar CPF
- Sistema deve validar formato do CPF
- Sistema deve buscar pessoa no banco de dados
- Sistema deve remover pessoa do banco de dados
- Sistema deve confirmar remoção com mensagem de sucesso
- Sistema deve informar quando pessoa não for encontrada

## RF002 - Gestão de Propostas

### RF002.1 - Cadastrar Proposta  
**Descrição**: O sistema deve permitir cadastrar propostas culturais em sessões.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve solicitar título da proposta
- Sistema deve solicitar descrição da proposta
- Sistema deve solicitar segmento cultural
- Sistema deve validar preenchimento de todos os campos
- Sistema deve criar instância de Proposta
- Sistema deve adicionar proposta à sessão
- Sistema deve confirmar cadastro com mensagem de sucesso

### RF002.2 - Listar Propostas
**Descrição**: O sistema deve exibir lista de todas as propostas cadastradas.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve buscar todas as propostas cadastradas
- Sistema deve exibir dados completos das propostas (ID, título, descrição, segmento cultural)
- Sistema deve apresentar lista formatada

## RF003 - Gestão de Sessões

### RF003.1 - Criar Nova Sessão
**Descrição**: O sistema deve permitir criar novas sessões do conselho cultural.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar nome da sessão
- Sistema deve solicitar data da sessão
- Sistema deve criar instância de Sessao com status CRIADA
- Sistema deve gerar ID único para a sessão
- Sistema deve adicionar sessão ao banco de dados
- Sistema deve confirmar criação com mensagem de sucesso

### RF003.2 - Adicionar Conselheiros à Sessão
**Descrição**: O sistema deve permitir adicionar conselheiros a uma sessão específica.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve exibir lista de conselheiros disponíveis
- Sistema deve permitir seleção múltipla de conselheiros
- Sistema deve adicionar conselheiros selecionados à sessão
- Sistema deve confirmar adição com mensagem de sucesso

### RF003.3 - Adicionar Ouvintes à Sessão
**Descrição**: O sistema deve permitir adicionar ouvintes a uma sessão específica.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve exibir lista de ouvintes disponíveis
- Sistema deve permitir seleção múltipla de ouvintes
- Sistema deve adicionar ouvintes selecionados à sessão
- Sistema deve confirmar adição com mensagem de sucesso

### RF003.4 - Adicionar Propostas à Sessão
**Descrição**: O sistema deve permitir adicionar propostas a uma sessão específica.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve exibir lista de propostas disponíveis
- Sistema deve permitir seleção múltipla de propostas
- Sistema deve adicionar propostas selecionadas à sessão
- Sistema deve confirmar adição com mensagem de sucesso

### RF003.5 - Iniciar Sessão
**Descrição**: O sistema deve permitir iniciar uma sessão criada.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve verificar se status é CRIADA
- Sistema deve alterar status para ATIVA
- Sistema deve confirmar início da sessão com mensagem de sucesso

### RF003.6 - Encerrar Sessão
**Descrição**: O sistema deve permitir encerrar uma sessão ativa.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve verificar se status é ATIVA
- Sistema deve alterar status para ENCERRADA
- Sistema deve confirmar encerramento da sessão com mensagem de sucesso

### RF003.7 - Listar Sessões
**Descrição**: O sistema deve exibir lista de todas as sessões cadastradas.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve buscar todas as sessões cadastradas
- Sistema deve exibir ID, nome, data e status de cada sessão
- Sistema deve apresentar lista formatada

### RF003.8 - Consultar Status da Sessão
**Descrição**: O sistema deve permitir consultar dados completos de uma sessão específica.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve exibir dados completos da sessão incluindo status
- Sistema deve informar quando sessão não for encontrada

## RF004 - Sistema de Votação

### RF004.1 - Registrar Voto
**Descrição**: O sistema deve permitir que conselheiros registrem votos em propostas durante sessões ativas.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência e status da sessão (deve ser ATIVA)
- Sistema deve solicitar CPF do conselheiro
- Sistema deve validar se conselheiro está presente na sessão
- Sistema deve exibir propostas disponíveis para votação
- Sistema deve permitir seleção da proposta
- Sistema deve permitir escolha do tipo de voto (SIM, NÃO, ABSTENÇÃO)
- Sistema deve verificar se conselheiro já votou na sessão
- Sistema deve registrar voto
- Sistema deve confirmar registro do voto com mensagem de sucesso

### RF004.2 - Listar Votos por Proposta
**Descrição**: O sistema deve permitir visualizar todos os votos registrados para uma proposta específica.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve exibir propostas da sessão
- Sistema deve permitir seleção da proposta
- Sistema deve exibir todos os votos registrados para a proposta
- Sistema deve exibir estatísticas de votação (quantidade de SIM, NÃO, ABSTENÇÃO)

## RF005 - Relatórios e Consultas

### RF005.1 - Exibir Dados de Votação
**Descrição**: O sistema deve permitir visualizar estatísticas gerais de votação de uma sessão.  
**Prioridade**: Baixa  
**Critérios de Aceitação**:
- Sistema deve solicitar ID da sessão
- Sistema deve validar existência da sessão
- Sistema deve exibir estatísticas gerais de votação da sessão
- Sistema deve informar quando sessão não for encontrada

## RF006 - Validações e Regras de Negócio

### RF006.1 - Validação de CPF
**Descrição**: O sistema deve validar formato e validade do CPF informado.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve verificar formato do CPF (XXX.XXX.XXX-XX)
- Sistema deve validar dígitos verificadores do CPF
- Sistema deve rejeitar CPFs inválidos com mensagem de erro

### RF006.2 - Validação de Email
**Descrição**: O sistema deve validar formato do email informado.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve verificar formato básico do email (usuario@dominio.com)
- Sistema deve rejeitar emails inválidos com mensagem de erro

### RF006.3 - Controle de Voto Único
**Descrição**: O sistema deve garantir que cada conselheiro vote apenas uma vez por sessão.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve verificar se conselheiro já votou na sessão
- Sistema deve impedir voto duplicado
- Sistema deve informar quando conselheiro já votou

### RF006.4 - Controle de Status da Sessão
**Descrição**: O sistema deve controlar o fluxo de status das sessões.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve permitir apenas transições válidas: CRIADA → ATIVA → ENCERRADA
- Sistema deve impedir operações inválidas baseadas no status atual
- Sistema deve informar quando operação não é permitida para o status atual

### RF006.5 - Validação de Participação em Sessão
**Descrição**: O sistema deve validar se pessoa está autorizada a participar da sessão.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve verificar se conselheiro/ouvinte foi adicionado à sessão
- Sistema deve impedir participação de pessoas não autorizadas
- Sistema deve informar quando pessoa não está autorizada

## RF007 - Interface do Usuário

### RF007.1 - Menu Principal
**Descrição**: O sistema deve apresentar menu principal com todas as opções disponíveis.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve exibir menu numerado com todas as funcionalidades
- Sistema deve permitir seleção por número
- Sistema deve validar entrada do usuário
- Sistema deve permitir sair do sistema

### RF007.2 - Mensagens de Feedback
**Descrição**: O sistema deve fornecer feedback claro para todas as operações.  
**Prioridade**: Média  
**Critérios de Aceitação**:
- Sistema deve exibir mensagens de sucesso para operações bem-sucedidas
- Sistema deve exibir mensagens de erro para operações falhadas
- Sistema deve usar símbolos visuais (✓ para sucesso, ✗ para erro)
- Sistema deve fornecer informações claras sobre o que fazer em caso de erro

## RF008 - Persistência de Dados

### RF008.1 - Armazenamento de Pessoas
**Descrição**: O sistema deve armazenar dados de todas as pessoas cadastradas.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve manter dados de conselheiros e ouvintes
- Sistema deve permitir recuperação de dados por CPF
- Sistema deve manter dados durante execução do programa

### RF008.2 - Armazenamento de Sessões
**Descrição**: O sistema deve armazenar dados de todas as sessões criadas.  
**Prioridade**: Alta  
**Critérios de Aceitação**: 
- Sistema deve manter dados de sessões com status atual
- Sistema deve permitir recuperação de sessões por ID
- Sistema deve manter dados durante execução do programa

### RF008.3 - Armazenamento de Propostas
**Descrição**: O sistema deve armazenar dados de todas as propostas cadastradas.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve manter dados de propostas
- Sistema deve permitir recuperação de propostas por ID
- Sistema deve manter dados durante execução do programa

### RF008.4 - Armazenamento de Votos
**Descrição**: O sistema deve armazenar dados de todos os votos registrados.  
**Prioridade**: Alta  
**Critérios de Aceitação**:
- Sistema deve manter dados de votos por sessão
- Sistema deve permitir recuperação de votos por proposta
- Sistema deve manter dados durante execução do programa

## Prioridades dos Requisitos

### Alta Prioridade
- RF001.1, RF001.2 (Cadastrar Conselheiro e Ouvinte)
- RF002.1 (Cadastrar Proposta)
- RF003.1, RF003.2, RF003.3, RF003.4, RF003.5, RF003.6 (Gestão completa de Sessões)
- RF004.1 (Registrar Voto)
- RF006.1, RF006.2, RF006.3, RF006.4, RF006.5 (Validações críticas)
- RF007.1 (Menu Principal)
- RF008.1, RF008.2, RF008.3, RF008.4 (Persistência de dados)

### Média Prioridade
- RF001.3, RF001.4, RF001.5, RF001.6 (Listagens e Busca)
- RF002.2 (Listar Propostas)
- RF003.7, RF003.8 (Consultas de Sessão)
- RF004.2 (Listar Votos)
- RF007.2 (Mensagens de Feedback)

### Baixa Prioridade
- RF001.7 (Remover Pessoa)
- RF005.1 (Relatórios)
