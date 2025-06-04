package com.carlos.movie_android.repositories

import com.carlos.movie_android.models.MovieModel

class MovieRepository {

    fun getMovies(): List<MovieModel> {
        return listOf(
            MovieModel(
                id = "1",
                title = "O Poderoso Chefão",
                year = 1972,
                genre = "Crime, Drama",
                synopsis = "O patriarca envelhecido de uma dinastia do crime organizada transfere o controle de seu império clandestino para seu filho relutante.",
                imageUrl = "https://image.tmdb.org/t/p/w500/3bhkrj58Vtu7enYsRolD1fZdja1.jpg"
            ),
            MovieModel(
                id = "2",
                title = "Um Sonho de Liberdade",
                year = 1994,
                genre = "Drama",
                synopsis = "Dois homens presos se unem ao longo de vários anos, encontrando consolo e eventual redenção através de atos comuns de decência.",
                imageUrl = "https://image.tmdb.org/t/p/w500/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg"
            ),
            MovieModel(
                id = "3",
                title = "O Cavaleiro das Trevas",
                year = 2008,
                genre = "Ação, Crime, Drama",
                synopsis = "Quando a ameaça conhecida como Coringa causa estragos e caos no povo de Gotham, Batman deve aceitar um dos maiores testes psicológicos e físicos de sua capacidade de combater a injustiça.",
                imageUrl = "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg"
            ),
            MovieModel(
                id = "4",
                title = "Pulp Fiction: Tempo de Violência",
                year = 1994,
                genre = "Crime, Drama",
                synopsis = "As vidas de dois assassinos da máfia, um boxeador, uma dupla de ladrões de lanchonete e uma esposa de gângster se entrelaçam em quatro contos de violência e redenção.",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg"
            ),
            MovieModel(
                id = "5",
                title = "Forrest Gump: O Contador de Histórias",
                year = 1994,
                genre = "Drama, Romance",
                synopsis = "As presidências de Kennedy e Johnson, o Vietnã, Watergate e outros eventos históricos se desenrolam através da perspectiva de um homem do Alabama com um QI de 75.",
                imageUrl = "https://image.tmdb.org/t/p/w500/saHP97rTPS5eLmrLQEcANmKrsFl.jpg"
            ),
            MovieModel(
                id = "6",
                title = "A Origem",
                year = 2010,
                genre = "Ação, Ficção Científica, Suspense",
                synopsis = "Um ladrão que rouba segredos corporativos através do uso da tecnologia de compartilhamento de sonhos é oferecido a chance de apagar seu passado como pagamento por um trabalho considerado impossível: a inserção.",
                imageUrl = "https://image.tmdb.org/t/p/w500/edv5CZvWj09upOsy2Y6IwDhK8bt.jpg"
            ),
            MovieModel(
                id = "7",
                title = "Clube da Luta",
                year = 1999,
                genre = "Drama",
                synopsis = "Um homem insatisfeito com sua vida conhece um vendedor de sabonetes que acredita que o autoconhecimento vem da dor. Juntos, fundam um clube secreto de luta clandestina que evolui para algo muito maior.",
                imageUrl = "https://image.tmdb.org/t/p/w500/bptfVGEQuv6vDTIMVCHjJ9Dz8PX.jpg"
            ),
            MovieModel(
                id = "8",
                title = "Interestelar",
                year = 2014,
                genre = "Aventura, Drama, Ficção Científica",
                synopsis = "Um grupo de exploradores faz uso de um buraco de minhoca recém-descoberto para superar as limitações da viagem espacial humana e salvar a humanidade.",
                imageUrl = "https://image.tmdb.org/t/p/w500/rAiYTfKGqDCRIIqo664sY9XZIvQ.jpg"
            ),
            MovieModel(
                id = "9",
                title = "Matrix",
                year = 1999,
                genre = "Ação, Ficção Científica",
                synopsis = "Um hacker descobre a verdade sobre sua realidade e seu papel na guerra contra seus controladores ao ser recrutado por um misterioso grupo de rebeldes.",
                imageUrl = "https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg"
            ),
            MovieModel(
                id = "10",
                title = "Os Bons Companheiros",
                year = 1990,
                genre = "Crime, Drama",
                synopsis = "A ascensão e queda de Henry Hill, um garoto do Brooklyn que se torna envolvido com a máfia e experimenta uma vida de luxo e violência.",
                imageUrl = "https://image.tmdb.org/t/p/w500/aKuFiU82s5ISJpGZp7YkIr3kCUd.jpg"
            )

        )
    }
    fun getMovieById(movieId: String): MovieModel? {
        return getMovies().find { it.id == movieId }
    }
}
