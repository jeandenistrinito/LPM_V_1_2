
/* ************************* authentification ********************* */

/*var btnEntrer = document.getElementById("btnEntrer");
var nomU = document.getElementById("utilisateurNom");
var mdpU = document.getElementById("utilisateurMdp");

let labelNomUser = document.querySelector("#labelNomUser");
let logoName = document.querySelector(".logo_name");

nomU.addEventListener('keyup',function (){
    nomU.style.borderColor = "#ccc";
})
mdpU.addEventListener('keyup',function (){
    mdpU.style.borderColor = "#ccc";
})

btnEntrer.addEventListener('click',function (){
    //$(".modal-busy").show();
    $.ajax({
        type : "GET",
        url : "/GetUserAuthentic?nomU="+nomU.value,
        success : function (result) {
            if (result.status === "success"){
                if (result.data === "NonExiste"){
                    //alert("Succès !!!! , utilisateur non existe");
                    nomU.style.borderColor = "red";
                }
                else {
                    nomU.style.borderColor = "#ccc";
                    if (result.data.motpassUtilisateur === mdpU.value){
                        mdpU.style.borderColor = "#ccc";
                        window.open("LPM-v-1","teste");


                    }
                    else {
                        mdpU.style.borderColor = "red";
                    }
                }
            }
        },
        error : function (erreur) {
            alert("Erreur ......");
            console.log("Erreur : "+erreur);
        }
    });
});*/

/* ************************ authentification fin ****************** */

/*let btn = document.querySelector("#btn");
let header = document.querySelector("#header")
let sidebar = document.querySelector(".sidebar");
let homeContent = document.querySelector(".home_content");

//sidebar.classList.toggle("active");
//header.classList.toggle("active");
//homeContent.classList.toggle("active");


btn.onclick = function (){
    sidebar.classList.toggle("active");
    header.classList.toggle("active");
    homeContent.classList.toggle("active");
}*/

setTheme('theme-dark');
function setTheme(themeName) {
    localStorage.setItem('theme', themeName);
    document.documentElement.className = themeName;
}

function toggleTheme() {
    if (localStorage.getItem('theme') === 'theme-dark') {
        setTheme('theme-light');
    } else {
        setTheme('theme-dark');
    }
}

/*const modeToggle = document.querySelector(".darklight");
modeToggle.addEventListener('click',()=>{
    modeToggle.classList.toggle("active");
    if (localStorage.getItem('theme') === 'theme-dark') {
        setTheme('theme-light');
    } else {
        setTheme('theme-dark');
    }
})*/

/* ******************* select actions ******************************** */
var tab = document.querySelectorAll(".boutonSelect");
for (var i=0;i<tab.length;i++){
    tab[i].addEventListener('click',teste);
}
function teste(){
    var bt = document.querySelector(".boutonPrintAj");
    bt.style.display='none';
}

/* ******************* impression BE ********************************** */
/*function printDiv1() {
    var divElements = document.getElementById("pageImprimer").innerHTML;
    var oldPage = document.body.innerHTML;
    document.body.innerHTML = "<html><head><title></title></head><body>" + divElements + "</body>";
    window.print();
    document.body.innerHTML = oldPage;
}*/

/* ************************************* tab Produit ******************************************* */

/**
 * Easy selector helper function
 */
const select = (el, all = false) => {
    el = el.trim()
    if (all) {
        return [...document.querySelectorAll(el)]
    } else {
        return document.querySelector(el)
    }
}

/**
 * Easy event listener function
 */
const on = (type, el, listener, all = false) => {
    if (all) {
        select(el, all).forEach(e => e.addEventListener(type, listener))
    } else {
        select(el, all).addEventListener(type, listener)
    }
}

/**
 * Easy on scroll event listener
 */
const onscroll = (el, listener) => {
    el.addEventListener('scroll', listener)
}
/**
 * Search bar toggle
 */
if (select('.search-bar-toggle')) {
    on('click', '.search-bar-toggle', function(e) {
        select('.search-bar').classList.toggle('search-bar-show')
    })
}

// Sidebar Slimscroll
/*let $slimScrolls = document.querySelector(".slimscroll");
if($slimScrolls.length > 0) {
    $slimScrolls.slimScroll({
        height: 'auto',
        width: '100%',
        position: 'right',
        size: '7px',
        color: '#ccc',
        wheelStep: 10,
        touchScrollStep: 100
    });
    var wHeight = $(window).height() - 60;
    $slimScrolls.height(wHeight);
    $('.sidebar .slimScrollDiv').height(wHeight);
    $(window).resize(function() {
        var rHeight = $(window).height() - 60;
        $slimScrolls.height(rHeight);
        $('.sidebar .slimScrollDiv').height(rHeight);
    });
}*/

$(document).ready(function() {

    // Variables declarations

    var $wrapper = $('.main-wrapper');
    var $pageWrapper = $('.page-wrapper');
    var $slimScrolls = $('.slimscroll');

    // Sidebar

    var Sidemenu = function() {
        this.$menuItem = $('#sidebar-menu a');
    };

    function init() {
        var $this = Sidemenu;
        $('#sidebar-menu a').on('click', function(e) {
            if($(this).parent().hasClass('submenu')) {
                e.preventDefault();
            }
            if(!$(this).hasClass('subdrop')) {
                $('ul', $(this).parents('ul:first')).slideUp(350);
                $('a', $(this).parents('ul:first')).removeClass('subdrop');
                $(this).next('ul').slideDown(350);
                $(this).addClass('subdrop');
            } else if($(this).hasClass('subdrop')) {
                $(this).removeClass('subdrop');
                $(this).next('ul').slideUp(350);
            }
        });
        $('#sidebar-menu ul li.submenu a.active').parents('li:last').children('a:first').addClass('active').trigger('click');
    }

    // Sidebar Initiate
    init();

    // Mobile menu sidebar overlay

    $('body').append('<div class="sidebar-overlay"></div>');
    $(document).on('click', '#mobile_btn', function() {
        $wrapper.toggleClass('slide-nav');
        $('.sidebar-overlay').toggleClass('opened');
        $('html').addClass('menu-opened');
        $('#task_window').removeClass('opened');
        return false;
    });

    $(".sidebar-overlay").on("click", function () {
        $('html').removeClass('menu-opened');
        $(this).removeClass('opened');
        $wrapper.removeClass('slide-nav');
        $('.sidebar-overlay').removeClass('opened');
        $('#task_window').removeClass('opened');
    });

    // Chat sidebar overlay

    $(document).on('click', '#task_chat', function() {
        $('.sidebar-overlay').toggleClass('opened');
        $('#task_window').addClass('opened');
        return false;
    });

    // Select 2

    if($('.select').length > 0) {
        $('.select').select2({
            minimumResultsForSearch: -1,
            width: '100%'
        });
    }

    // Modal Popup hide show

    if($('.modal').length > 0 ){
        var modalUniqueClass = ".modal";
        $('.modal').on('show.bs.modal', function(e) {
            var $element = $(this);
            var $uniques = $(modalUniqueClass + ':visible').not($(this));
            if ($uniques.length) {
                $uniques.modal('hide');
                $uniques.one('hidden.bs.modal', function(e) {
                    $element.modal('show');
                });
                return false;
            }
        });
    }

    // Floating Label

    if($('.floating').length > 0 ){
        $('.floating').on('focus blur', function (e) {
            $(this).parents('.form-focus').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
        }).trigger('blur');
    }

    // Sidebar Slimscroll

    if($slimScrolls.length > 0) {
        $slimScrolls.slimScroll({
            height: 'auto',
            width: '100%',
            position: 'right',
            size: '7px',
            color: '#ccc',
            wheelStep: 10,
            touchScrollStep: 100
        });
        var wHeight = $(window).height() - 60;
        $slimScrolls.height(wHeight);
        $('.sidebar .slimScrollDiv').height(wHeight);
        $(window).resize(function() {
            var rHeight = $(window).height() - 60;
            $slimScrolls.height(rHeight);
            $('.sidebar .slimScrollDiv').height(rHeight);
        });
    }

    // Page Content Height

    var pHeight = $(window).height();
    $pageWrapper.css('min-height', pHeight);
    $(window).resize(function() {
        var prHeight = $(window).height();
        $pageWrapper.css('min-height', prHeight);
    });

    // Date Time Picker

    if($('.datetimepicker').length > 0) {
        $('.datetimepicker').datetimepicker({
            format: 'DD/MM/YYYY',
            icons: {
                up: "fa fa-angle-up",
                down: "fa fa-angle-down",
                next: 'fa fa-angle-right',
                previous: 'fa fa-angle-left'
            }
        });
    }

    // Datatable

    if($('.datatable').length > 0) {
        $('.datatable').DataTable({
            "bFilter": false,
        });
    }

    // Tooltip

    if($('[data-toggle="tooltip"]').length > 0) {
        $('[data-toggle="tooltip"]').tooltip();
    }

    // Email Inbox

    if($('.clickable-row').length > 0 ){
        $(".clickable-row").click(function() {
            window.location = $(this).data("href");
        });
    }

    // Check all email

    $(document).on('click', '#check_all', function() {
        $('.checkmail').click();
        return false;
    });
    if($('.checkmail').length > 0) {
        $('.checkmail').each(function() {
            $(this).on('click', function() {
                if($(this).closest('tr').hasClass('checked')) {
                    $(this).closest('tr').removeClass('checked');
                } else {
                    $(this).closest('tr').addClass('checked');
                }
            });
        });
    }

    // Mail important

    $(document).on('click', '.mail-important', function() {
        $(this).find('i.fa').toggleClass('fa-star').toggleClass('fa-star-o');
    });

    // Summernote

    if($('.summernote').length > 0) {
        $('.summernote').summernote({
            height: 200,                 // set editor height
            minHeight: null,             // set minimum height of editor
            maxHeight: null,             // set maximum height of editor
            focus: false                 // set focus to editable area after initializing summernote
        });
    }

    // Task Complete

    $(document).on('click', '#task_complete', function() {
        $(this).toggleClass('task-completed');
        return false;
    });

    // Multiselect

    if($('#customleave_select').length > 0) {
        $('#customleave_select').multiselect();
    }
    if($('#edit_customleave_select').length > 0) {
        $('#edit_customleave_select').multiselect();
    }

    // Leave Settings button show

    $(document).on('click', '.leave-edit-btn', function() {
        $(this).removeClass('leave-edit-btn').addClass('btn btn-white leave-cancel-btn').text('Cancel');
        $(this).closest("div.leave-right").append('<button class="btn btn-primary leave-save-btn" type="submit">Save</button>');
        $(this).parent().parent().find("input").prop('disabled', false);
        return false;
    });
    $(document).on('click', '.leave-cancel-btn', function() {
        $(this).removeClass('btn btn-white leave-cancel-btn').addClass('leave-edit-btn').text('Edit');
        $(this).closest("div.leave-right").find(".leave-save-btn").remove();
        $(this).parent().parent().find("input").prop('disabled', true);
        return false;
    });

    $(document).on('change', '.leave-box .onoffswitch-checkbox', function() {
        var id = $(this).attr('id').split('_')[1];
        if ($(this).prop("checked") == true) {
            $("#leave_"+id+" .leave-edit-btn").prop('disabled', false);
            $("#leave_"+id+" .leave-action .btn").prop('disabled', false);
        }
        else {
            $("#leave_"+id+" .leave-action .btn").prop('disabled', true);
            $("#leave_"+id+" .leave-cancel-btn").parent().parent().find("input").prop('disabled', true);
            $("#leave_"+id+" .leave-cancel-btn").closest("div.leave-right").find(".leave-save-btn").remove();
            $("#leave_"+id+" .leave-cancel-btn").removeClass('btn btn-white leave-cancel-btn').addClass('leave-edit-btn').text('Edit');
            $("#leave_"+id+" .leave-edit-btn").prop('disabled', true);
        }
    });

    $('.leave-box .onoffswitch-checkbox').each(function() {
        var id = $(this).attr('id').split('_')[1];
        if ($(this).prop("checked") == true) {
            $("#leave_"+id+" .leave-edit-btn").prop('disabled', false);
            $("#leave_"+id+" .leave-action .btn").prop('disabled', false);
        }
        else {
            $("#leave_"+id+" .leave-action .btn").prop('disabled', true);
            $("#leave_"+id+" .leave-cancel-btn").parent().parent().find("input").prop('disabled', true);
            $("#leave_"+id+" .leave-cancel-btn").closest("div.leave-right").find(".leave-save-btn").remove();
            $("#leave_"+id+" .leave-cancel-btn").removeClass('btn btn-white leave-cancel-btn').addClass('leave-edit-btn').text('Edit');
            $("#leave_"+id+" .leave-edit-btn").prop('disabled', true);
        }
    });

    // Placeholder Hide

    if ($('.otp-input, .zipcode-input input, .noborder-input input').length > 0) {
        $('.otp-input, .zipcode-input input, .noborder-input input').focus(function () {
            $(this).data('placeholder', $(this).attr('placeholder'))
                .attr('placeholder', '');
        }).blur(function () {
            $(this).attr('placeholder', $(this).data('placeholder'));
        });
    }

    // OTP Input

    if ($('.otp-input').length > 0) {
        $(".otp-input").keyup(function(e) {
            if ((e.which >= 48 && e.which <= 57) || (e.which >= 96 && e.which <= 105)) {
                $(e.target).next('.otp-input').focus();
            } else if (e.which == 8) {
                $(e.target).prev('.otp-input').focus();
            }
        });
    }

    // Small Sidebar

    $(document).on('click', '#toggle_btn', function() {
        if($('body').hasClass('mini-sidebar')) {
            $('body').removeClass('mini-sidebar');
            $('.subdrop + ul').slideDown();
        } else {
            $('body').addClass('mini-sidebar');
            $('.subdrop + ul').slideUp();
        }
        return false;
    });
    $(document).on('mouseover', function(e) {
        e.stopPropagation();
        if($('body').hasClass('mini-sidebar') && $('#toggle_btn').is(':visible')) {
            var targ = $(e.target).closest('.sidebar').length;
            if(targ) {
                $('body').addClass('expand-menu');
                $('.subdrop + ul').slideDown();
            } else {
                $('body').removeClass('expand-menu');
                $('.subdrop + ul').slideUp();
            }
            return false;
        }
    });

    $(document).on('click', '.top-nav-search .responsive-search', function() {
        $('.top-nav-search').toggleClass('active');
    });

    $(document).on('click', '#file_sidebar_toggle', function() {
        $('.file-wrap').toggleClass('file-sidebar-toggle');
    });

    $(document).on('click', '.file-side-close', function() {
        $('.file-wrap').removeClass('file-sidebar-toggle');
    });

    if($('.kanban-wrap').length > 0) {
        $(".kanban-wrap").sortable({
            connectWith: ".kanban-wrap",
            handle: ".kanban-box",
            placeholder: "drag-placeholder"
        });
    }

});

// Loader

$(window).on ('load', function (){
    $('#loader').delay(100).fadeOut('slow');
    $('#loader-wrapper').delay(500).fadeOut('slow');
});

/* ----------------------------------- produit details --------------------------------------- */

/* ------------------------- plein ecran ----------------------------------------------- */
// toggle full screen
function toggleFullScreen() {
    var a = $(window).height() - 10;

    if (!document.fullscreenElement && // alternative standard method
        !document.mozFullScreenElement && !document.webkitFullscreenElement) { // current working methods
        if (document.documentElement.requestFullscreen) {
            document.documentElement.requestFullscreen();
        } else if (document.documentElement.mozRequestFullScreen) {
            document.documentElement.mozRequestFullScreen();
        } else if (document.documentElement.webkitRequestFullscreen) {
            document.documentElement.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
        }
    } else {
        if (document.cancelFullScreen) {
            document.cancelFullScreen();
        } else if (document.mozCancelFullScreen) {
            document.mozCancelFullScreen();
        } else if (document.webkitCancelFullScreen) {
            document.webkitCancelFullScreen();
        }
    }
}

/* ---------------------------------------------- modal ----------------------------------------- */

/*var modal = document.getElementById("prixSpecial");
var modalBtn = document.getElementById("boutonPrixSpecial");
var closeBtn = document.querySelector(".closeBtn0");

modalBtn.addEventListener('click',openModal);

function openModal(){
    modal.classList.add('active');
    //modal.style.display='block';
}*/










