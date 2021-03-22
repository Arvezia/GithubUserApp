package com.naufaldy.githubuserapp

object UserData {
private val githubUsername = arrayOf(
    "virganeo",
    "milkran",
    "rollmir",
    "avas123",
    "DCbell",
    "Emmamilia",
    "Greenworldz",
    "Jos_Gonzalezzz225",
    "josecollins",
    "NatalieClark1989"
)
    private val githubName = arrayOf(
        "Aiden Thompson",
        "Andrew Moore",
        "Ashley Robinson",
        "Ava Smith",
        "Daniel Campbell",
        "Emma Hill",
        "Jackson Green",
        "Jos Gonzalez",
        "Jose Collins",
        "Natalie Clark"
    )
    private val githubPhoto = intArrayOf(
        R.drawable.aiden_thompson,
        R.drawable.andrew_moore,
        R.drawable.ashley_robinson,
        R.drawable.ava_smith,
        R.drawable.daniel_campbell,
        R.drawable.emma_hill,
        R.drawable.jackson_green,
        R.drawable.jos_gonzalez,
        R.drawable.jose_collins,
        R.drawable.natalie_clark,
    )
    val listdata:ArrayList<GithubUser>
    get(){
    val list = arrayListOf<GithubUser>()
            for (
                position in githubUsername.indices){
                val githubUser = GithubUser(
                        githubUsername[position],
                        githubName[position],
                        githubPhoto[position]
                )
                githubUser.username
                githubUser.name
                githubUser.photo
                list.add(githubUser)
            }
            return list
    }
}