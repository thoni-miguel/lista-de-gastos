# 📱 Lista de Gastos – Controle Simples e Personalizado

## 🎯 Objetivo Geral

Desenvolver um aplicativo Android em Kotlin que funcione como uma lista de tarefas focada no **registro, organização e análise de pequenos gastos do dia a dia**, com persistência local utilizando **SQLite**. O app visa facilitar o controle financeiro pessoal de forma simples, intuitiva e personalizada.

---

## ✅ Funcionalidades Principais

- [x] **Criar anotações de gasto** com:
  - Título
  - Valor
  - Categoria (personalizável)
  - Descrição opcional

- [x] **Visualizar todas as anotações salvas**
- [x] **Editar ou excluir um registro existente**
- [x] **Ver detalhes de uma anotação individual**

---

## 🧠 Funcionalidades Extras

- [x] Validação de dados obrigatórios (ex: título e valor não podem estar vazios)
- [x] Notificações locais de lembrete como:
  - “Oiii! Já lembrou de anotar seus gastos hoje? 💸🤑”
- [x] Categorias personalizáveis (ex: “Doces”, “Higiene”, “Mercado”)
- [x] Design com Material Design, responsivo e amigável
- [ ] Possibilidade futura de comparar gastos por categoria

---

## 📲 Estrutura de Telas

1. **Tela de Listagem**: mostra todos os gastos registrados
2. **Tela de Inserção/Edição**: permite criar ou editar um gasto
3. **Tela de Detalhes**: exibe os dados completos de uma anotação individual

---

## 💾 Persistência de Dados

- Utiliza **SQLite nativo**, com banco de dados local no dispositivo

---

## 🔔 Notificações

- Notificações diárias para lembrar o usuário de registrar os gastos

---

## 🛠 Tecnologias Utilizadas

| Tecnologia        | Finalidade                             |
|-------------------|----------------------------------------|
| Kotlin            | Linguagem principal do app             |
| Jetpack Compose   | Construção da interface                |
| SQLite            | Banco de dados local                   |
| Android Studio    | IDE de desenvolvimento                 |
| Material Design   | Padrões visuais e UX                   |

---

## 🎓 Requisitos Atendidos

- ✅ CRUD com SQLite
- ✅ Persistência local
- ✅ 3+ telas
- ✅ Validação de dados
- ✅ Interface com Material Design
- ✅ Notificações locais
- ✅ Compatível com Android 6.0+
- ✅ App leve e fluido

---

## 💡 Inspiração

> A ideia nasceu da necessidade de anotar pequenos gastos do dia a dia, como compras no mercado, e organizá-los por categorias como “higiene” ou “doces”. Assim, o usuário pode refletir sobre seus hábitos e evitar desperdícios, de forma leve, divertida e útil.
