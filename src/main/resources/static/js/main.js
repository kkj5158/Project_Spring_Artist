// 랭킹 끌고와서 그리기 


// 클릭시에 아티스트 팬명록 페이지로의 이동 
$(document).ready(function () {
  $(document).on("click", ".namebox", function () {
    // alert('클릭됨');

    var artist_id_num = $(this).attr("id");
    // alert(artist_id_num);

    var url = $(location).attr("href");

    const ourl = new URL(url)

    // console.log(ourl.origin)

    moveurl = ourl.origin + "/" + "artist?" + "artist_id_num=" + artist_id_num;

    // console.log(moveurl)

    window.location.href = moveurl;
  });
});