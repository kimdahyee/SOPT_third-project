package ddwucom.mobile.sopt.sopt3.sopt_third_project.data

data class ResponseLogin(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : SomeData?
)

data class SomeData(
    val jwt : String
)