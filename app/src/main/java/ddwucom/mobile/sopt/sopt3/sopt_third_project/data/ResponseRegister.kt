package ddwucom.mobile.sopt.sopt3.sopt_third_project.data

data class ResponseRegister(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : SomeData?
)