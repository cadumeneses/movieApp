# 🎬 Aplicativo de Filmes

Este é um aplicativo Android nativo simples desenvolvido em Kotlin, que demonstra a criação de um app com duas telas, exibição de lista de itens e navegação para detalhes, seguindo boas práticas de desenvolvimento mobile.

---

## 📌 Visão Geral

O aplicativo **"Carlos Movie App"** exibe uma lista estática de filmes.  
Ao clicar em qualquer filme da lista, o usuário é levado a uma segunda tela que mostra os detalhes completos desse filme, incluindo **título, ano, gênero, sinopse** e **pôster**.

---

## ✨ Funcionalidades

- ✅ **Tela de Lista de Filmes**: Exibe uma lista rolável de filmes com seus títulos, anos e gêneros.  
- ✅ **Navegação para Detalhes**: Ao clicar em um item da lista, o aplicativo navega para a tela de detalhes.  
- ✅ **Tela de Detalhes do Filme**: Mostra título, ano, gênero, sinopse e um pôster (com placeholder).  
- ✅ **Botão de Voltar Customizado**: Permite retornar à lista de filmes.

---

## 🧱 Arquitetura

O projeto segue a arquitetura **MVVM** (Model-View-ViewModel):

- **Model** (`model/Movie.kt`)  
  Representa a estrutura de dados de um filme.

- **Repository** (`data/MovieRepository.kt`)  
  Fornece uma lista mockada de filmes. Em um cenário real, interagiria com API ou banco de dados local.

- **ViewModels**  
  - `ui/movielist/MovieListViewModel.kt`  
  - `ui/moviedetail/MovieDetailViewModel.kt`  
  Contêm a lógica de negócios e expõem os dados com LiveData.

- **Views (Activities)**  
  - `ui/movielist/MovieListActivity.kt`  
  - `ui/moviedetail/MovieDetailActivity.kt`  
  Exibem a interface do usuário e observam as mudanças nos ViewModels.

---

## 🛠️ Tecnologias e Bibliotecas Utilizadas

- **Kotlin**
- **Android Jetpack**:
  - ViewModel  
  - LiveData  
  - RecyclerView  
  - CardView  
  - ConstraintLayout  
  - View Binding
- **Glide**: Para carregamento e cache de imagens

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

- Android Studio (recomendado: Arctic Fox ou superior)
- SDK do Android

### Clonar o Repositório

```bash
git clone <https://github.com/cadumeneses/movieApp>
cd movieApp
```
### Abrir no Android Studio

- Abra o Android Studio.
- Selecione Open an existing Android Studio project e navegue até a pasta do projeto.
- Aguarde a sincronização do Gradle.

### 📱 Executar o Aplicativo
- Conecte um dispositivo ou inicie um emulador.
- Clique em Run no Android Studio.
- Selecione o dispositivo para instalação e execução do app.

### 🗂️ Estrutura do Projeto

app/src/main/java/com/example/movieapp/
├── ui/
│   ├── movieList/
│   │   ├── MovieListActivity.kt
│   │   ├── MovieListAdapter.kt
│   │   └── MovieListViewModel.kt
│   └── movieDetail/
│       ├── MovieDetailActivity.kt
│       └── MovieDetailViewModel.kt
├── repositories/
│   └── MovieRepository.kt
├── model/
│   └── MovieModel.kt

