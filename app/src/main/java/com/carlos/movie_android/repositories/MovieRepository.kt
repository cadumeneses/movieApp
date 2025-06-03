package com.carlos.movie_android.repositories

import com.carlos.movie_android.models.MovieModel

/**
 * Repositório para fornecer dados de filmes.
 * Para este teste, os dados são mockados estaticamente.
 */
class MovieRepository {

    /**
     * Retorna uma lista de filmes mockados.
     */
    fun getMovies(): List<MovieModel> {
        return listOf(
            MovieModel(
                id = "1",
                title = "O Poderoso Chefão",
                year = 1972,
                genre = "Crime, Drama",
                synopsis = "O patriarca envelhecido de uma dinastia do crime organizada transfere o controle de seu império clandestino para seu filho relutante.",
                imageUrl = "https://placehold.co/150x225/E0E0E0/333333?text=Poderoso+Chefão"
            ),
            MovieModel(
                id = "2",
                title = "Um Sonho de Liberdade",
                year = 1994,
                genre = "Drama",
                synopsis = "Dois homens presos se unem ao longo de vários anos, encontrando consolo e eventual redenção através de atos comuns de decência.",
                imageUrl = "https://placehold.co/150x225/E0E0E0/333333?text=Sonho+Liberdade"
            ),
            MovieModel(
                id = "3",
                title = "O Cavaleiro das Trevas",
                year = 2008,
                genre = "Ação, Crime, Drama",
                synopsis = "Quando a ameaça conhecida como Coringa causa estragos e caos no povo de Gotham, Batman deve aceitar um dos maiores testes psicológicos e físicos de sua capacidade de combater a injustiça.",
                imageUrl = "https://placehold.co/150x225/E0E0E0/333333?text=Cavaleiro+Trevas"
            ),
            MovieModel(
                id = "4",
                title = "Pulp Fiction: Tempo de Violência",
                year = 1994,
                genre = "Crime, Drama",
                synopsis = "As vidas de dois assassinos da máfia, um boxeador, uma dupla de ladrões de lanchonete e uma esposa de gângster se entrelaçam em quatro contos de violência e redenção.",
                imageUrl = "https://placehold.co/150x225/E0E0E0/333333?text=Pulp+Fiction"
            ),
            MovieModel(
                id = "5",
                title = "Forrest Gump: O Contador de Histórias",
                year = 1994,
                genre = "Drama, Romance",
                synopsis = "As presidências de Kennedy e Johnson, o Vietnã, Watergate e outros eventos históricos se desenrolam através da perspectiva de um homem do Alabama com um QI de 75.",
                imageUrl = "https://placehold.co/150x225/E0E0E0/333333?text=Forrest+Gump"
            )
        )
    }
    fun getMovieById(movieId: String): MovieModel? {
        return getMovies().find { it.id == movieId }
    }
}
