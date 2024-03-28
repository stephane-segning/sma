import {Link} from "react-router-dom";

const menuItems = [
    {
        name: 'Staff',
        path: '/staffs',
    },
    {
        name: 'Student',
        path: '/students',
    },
    {
        name: 'Courses',
        path: '/courses',
    },
]

export function Navbar() {
    return (
        <div className="navbar bg-base-200">
            <div className="navbar-start">
                <div className="dropdown">
                    <div tabIndex={0} role="button" className="btn btn-ghost sm:hidden">
                        <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                                  d="M4 6h16M4 12h8m-8 6h16"/>
                        </svg>
                    </div>
                    <ul tabIndex={0}
                        className="menu menu-md dropdown-content mt-3 z-[1] p-2 shadow bg-base-100 rounded-box w-52">
                        {menuItems.map((item, index) => (
                            <li key={index}><Link to={item.path}>{item.name}</Link></li>
                        ))}
                    </ul>
                </div>
                <a className="btn btn-ghost text-xl">SMA</a>
            </div>
            <div className="navbar-center hidden sm:flex">
                <ul className="menu menu-horizontal px-1">
                    {menuItems.map((item, index) => (
                        <li key={index}><Link to={item.path}>{item.name}</Link></li>
                    ))}
                </ul>
            </div>
            <div className="navbar-end">
                <a className="btn btn-neutral">Login</a>
            </div>
        </div>
    )
}