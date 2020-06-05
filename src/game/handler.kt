package game
fun printcur(score : Int) = println("Current Score : $score")
fun guess(i : Int) = println("Your ${i+1} Guess")
fun check(guess_word : String? , actual_word  : String) : List<Int>{
    var correct_index = mutableListOf<Int>()
    for(i in 0..actual_word.length-1)
    {
        if(actual_word[i] == guess_word?.get(i))
            correct_index.add(i)
    }
    return correct_index
}
fun main() {
    var f = filehandle("G:\\personal\\projects\\Game_of_Anagrams\\src\\game\\engmix.txt")
    f.reading()
    while(true)
    {
        println("Enter Your Name...")
        var name = readLine()
        println("==============Welcome $name===============")
        println("==========================================")
        var words = f.generate()
        var players_score = 0
        for(i in 0..words.size-1)
        {

            var word = utility(words[i])
            var shuffled_word = word.shuffling()
            var arr = mutableListOf<Int>()
            for(i in  0..word.s.length-1)
                arr.add(0)
            println("Total Score : $players_score")
            println("$name Here's your ${i+1} Word : $shuffled_word")
            println("This word score achievable : ${word.totalscore}")
            var curr_score =0
            for(j in 0..2)
            {
                guess(j)
                var guess_word = readLine()
                var correctguess = check(guess_word,word.s)
                if(correctguess.size == word.s.length) {
                    println("You Guessed it correct !!")
                    curr_score =  word.totalscore
                    break
                }
                else {
                    for (k in 0..correctguess.size - 1) {
                        if (arr[correctguess[k]] != 1) {
                            arr[correctguess[k]] = 1
                            curr_score = curr_score + word.char_score.get(correctguess[k])!!.toInt()
                        }
                    }
                    for(k in  0..word.s.length-1)
                    {
                        if(correctguess.contains(k))
                            print("${word.s[k]}")
                        else
                            print("_")
                    }
                    println()
                    printcur(curr_score)
                }

            }
            players_score = players_score + curr_score
        }
        println("End Score : $players_score")
        println("Want to play again ? Type \"Yes\" or \"No\" ${if(readLine() == "Yes") {continue} else { break}}")
    }
}