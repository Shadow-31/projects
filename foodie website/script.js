const header = document.querySelector('.header');
const btnNav = document.querySelector('.btn-mobile-nav');
const allLinks = document.querySelectorAll("a:link");
const sectionHeroEl = document.querySelector('.section-hero');

btnNav.addEventListener('click', function () {
    header.classList.toggle("nav--open");
})

allLinks.forEach(function (link) {
    link.addEventListener('click', function (e) {
        e.preventDefault();
        const href = link.getAttribute("href")

        if (href === "#") {
            window.scrollTo({
                top: 0,
                behavior: "smooth",
            })
        }

        if (href !== "#" && href.startsWith('#')) {
            const sectionEl = document.querySelector(href);
            sectionEl.scrollIntoView({ behavior: "smooth" })
        }

        if (link.classList.contains("main-nav-link"))
            header.classList.toggle("nav--open");
    })
})

const obs = new IntersectionObserver(
    function (entries) {
        const ent = entries[0];


        if (ent.isIntersecting === false) {
            document.body.classList.add('sticky')
        }

        if (ent.isIntersecting === true) {
            document.body.classList.remove('sticky')
        }
    },
    {
        root: null,
        threshold: 0,
        rootMargin: '-80px',
    }
);
obs.observe(sectionHeroEl);