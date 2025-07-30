# Casos de Uso - Sistema Cultura em Pauta

## Visão Geral do Sistema
O sistema "Cultura em Pauta" é uma aplicação para gerenciamento de sessões de conselho cultural, permitindo o cadastro de pessoas (conselheiros e ouvintes), criação de propostas culturais, gestão de sessões e sistema de votação.

## Entidades Principais do Model

### 1. **Pessoa** (Classe Abstrata)
- **Atributos**: nome, CPF, email, telefone, PCD, raça, renda, ocupação profissional, carreira cultural
- **Subclasses**: Conselheiro, Ouvinte

### 2. **Conselheiro** (extends Pessoa, implements Votante)
- Representa membros do conselho com direito a voto
- Pode participar de sessões e votar em propostas

### 3. **Ouvinte** (extends Pessoa)
- Representa participantes sem direito a voto
- Pode participar de sessões apenas como observador

### 4. **Sessao**
- **Atributos**: ID, nome da sessão, data, conselheiros presentes, ouvintes presentes, propostas, votos, status
- **Status**: CRIADA, ATIVA, ENCERRADA
- **Funcionalidades**: iniciar(), encerrar(), adicionarConselheiro(), adicionarOuvinte(), adicionarProposta(), registrarVoto()

### 5. **Proposta**
- **Atributos**: ID, título, descrição, segmento cultural
- Representa propostas culturais que serão votadas nas sessões

### 6. **Voto**
- **Atributos**: votante, proposta, tipo de voto
- **Tipos**: SIM, NÃO, ABSTENÇÃO
- Registra o voto de um conselheiro em uma proposta específica

### 7. **CarreiraCultural**
- **Atributos**: atuação cultural, segmento cultural, grupo cultural
- Informações sobre a carreira cultural da pessoa

## Casos de Uso

### **Gestão de Pessoas**

#### UC001 - Cadastrar Conselheiro
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sistema inicializado
- **Fluxo Principal**:
  1. Sistema solicita dados pessoais (nome, CPF, email, telefone, PCD, raça, renda, ocupação)
  2. Sistema solicita dados da carreira cultural (atuação, segmento, grupo)
  3. Sistema valida CPF e email
  4. Sistema cria instância de Conselheiro
  5. Sistema adiciona à lista de pessoas e votantes
  6. Sistema confirma cadastro

#### UC002 - Cadastrar Ouvinte
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sistema inicializado
- **Fluxo Principal**:
  1. Sistema solicita dados pessoais (nome, CPF, email, telefone, PCD, raça, renda, ocupação)
  2. Sistema solicita dados da carreira cultural (atuação, segmento, grupo)
  3. Sistema valida CPF e email
  4. Sistema cria instância de Ouvinte
  5. Sistema adiciona à lista de pessoas
  6. Sistema confirma cadastro

#### UC003 - Listar Conselheiros
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Conselheiros cadastrados no sistema
- **Fluxo Principal**:
  1. Sistema busca todas as pessoas do tipo Conselheiro
  2. Sistema exibe lista com nome e segmento cultural

#### UC004 - Listar Ouvintes
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Ouvintes cadastrados no sistema
- **Fluxo Principal**:
  1. Sistema busca todas as pessoas do tipo Ouvinte
  2. Sistema exibe lista com nome e segmento cultural

#### UC005 - Listar Pessoas Cadastradas
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Pessoas cadastradas no sistema
- **Fluxo Principal**:
  1. Sistema busca todas as pessoas cadastradas (conselheiros e ouvintes)
  2. Sistema exibe lista com nome e segmento cultural de cada pessoa
  3. Sistema apresenta lista consolidada de todos os participantes

#### UC006 - Buscar Pessoa por CPF
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Pessoas cadastradas no sistema
- **Fluxo Principal**:
  1. Sistema solicita CPF
  2. Sistema valida formato do CPF
  3. Sistema busca pessoa no banco de dados
  4. Sistema exibe dados completos da pessoa

#### UC007 - Remover Pessoa por CPF
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Pessoa cadastrada no sistema
- **Fluxo Principal**:
  1. Sistema solicita CPF
  2. Sistema valida formato do CPF
  3. Sistema busca pessoa no banco de dados
  4. Sistema remove pessoa do banco de dados
  5. Sistema confirma remoção

### **Gestão de Propostas**

#### UC008 - Cadastrar Proposta
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão criada
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema solicita título da proposta
  4. Sistema solicita descrição da proposta
  5. Sistema solicita segmento cultural
  6. Sistema valida preenchimento de todos os campos
  7. Sistema cria instância de Proposta
  8. Sistema adiciona proposta à sessão
  9. Sistema confirma cadastro

#### UC009 - Listar Propostas
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Propostas cadastradas no sistema
- **Fluxo Principal**:
  1. Sistema busca todas as propostas cadastradas
  2. Sistema exibe lista com dados completos das propostas

### **Gestão de Sessões**

#### UC010 - Criar Nova Sessão
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sistema inicializado
- **Fluxo Principal**:
  1. Sistema solicita nome da sessão
  2. Sistema solicita data da sessão
  3. Sistema cria instância de Sessao com status CRIADA
  4. Sistema gera ID único para a sessão
  5. Sistema adiciona sessão ao banco de dados
  6. Sistema confirma criação

#### UC011 - Adicionar Conselheiros à Sessão
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão criada, conselheiros cadastrados
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema exibe lista de conselheiros disponíveis
  4. Sistema solicita seleção dos conselheiros
  5. Sistema adiciona conselheiros selecionados à sessão
  6. Sistema confirma adição

#### UC012 - Adicionar Ouvintes à Sessão
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão criada, ouvintes cadastrados
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema exibe lista de ouvintes disponíveis
  4. Sistema solicita seleção dos ouvintes
  5. Sistema adiciona ouvintes selecionados à sessão
  6. Sistema confirma adição

#### UC013 - Adicionar Propostas à Sessão
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão criada, propostas cadastradas
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema exibe lista de propostas disponíveis
  4. Sistema solicita seleção das propostas
  5. Sistema adiciona propostas selecionadas à sessão
  6. Sistema confirma adição

#### UC014 - Iniciar Sessão
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão criada com status CRIADA
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema verifica se status é CRIADA
  4. Sistema altera status para ATIVA
  5. Sistema confirma início da sessão

#### UC015 - Encerrar Sessão
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão com status ATIVA
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema verifica se status é ATIVA
  4. Sistema altera status para ENCERRADA
  5. Sistema confirma encerramento da sessão

#### UC016 - Listar Sessões
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessões criadas no sistema
- **Fluxo Principal**:
  1. Sistema busca todas as sessões cadastradas
  2. Sistema exibe lista com ID, nome, data e status

#### UC017 - Consultar Status da Sessão
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão criada no sistema
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema exibe dados completos da sessão incluindo status

### **Sistema de Votação**

#### UC018 - Registrar Voto
- **Ator**: Conselheiro
- **Pré-requisitos**: Sessão ativa, conselheiro presente, proposta disponível
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência e status da sessão (deve ser ATIVA)
  3. Sistema solicita CPF do conselheiro
  4. Sistema valida se conselheiro está presente na sessão
  5. Sistema exibe propostas disponíveis para votação
  6. Sistema solicita índice da proposta
  7. Sistema solicita tipo de voto (SIM, NÃO, ABSTENÇÃO)
  8. Sistema verifica se conselheiro já votou
  9. Sistema registra voto
  10. Sistema confirma registro do voto

#### UC019 - Listar Votos por Proposta
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão com votos registrados
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema exibe propostas da sessão
  4. Sistema solicita índice da proposta
  5. Sistema exibe todos os votos registrados para a proposta
  6. Sistema exibe estatísticas de votação

### **Relatórios e Consultas**

#### UC020 - Exibir Dados de Votação
- **Ator**: Administrador do Sistema
- **Pré-requisitos**: Sessão com votos registrados
- **Fluxo Principal**:
  1. Sistema solicita ID da sessão
  2. Sistema valida existência da sessão
  3. Sistema exibe estatísticas gerais de votação da sessão

## Tecnologias e Padrões Utilizados

- **Linguagem**: Java
- **Arquitetura**: Camadas (Model, Service, UI, Repository)