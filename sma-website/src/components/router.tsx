import {createHashRouter, Navigate, Outlet,} from "react-router-dom";
import {StaffsScreen} from "../screens/staffs.screen.tsx";
import {Navbar} from "./navbar.tsx";
import {StudentsScreen} from "../screens/students.screen.tsx";
import {CoursesScreen} from "../screens/courses.screen.tsx";

export const router = createHashRouter([
    {
        path: '/',
        element: (
            <>
                <Navbar/>
                <Outlet/>
            </>
        ),
        children: [
            {
                path: "/staffs",
                element: <StaffsScreen/>,
            },
            {
                path: "/students",
                element: <StudentsScreen/>,
            },
            {
                path: "/courses",
                element: <CoursesScreen/>,
            },
        ],
    },
    {
        path: '*',
        element: <Navigate to='/staffs' replace/>,
    }
]);