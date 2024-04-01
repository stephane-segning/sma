import {createHashRouter, Navigate, Outlet,} from "react-router-dom";
import {StaffsScreen} from "../screens/staffs.screen.tsx";
import {Navbar} from "./navbar.tsx";
import {StudentsScreen} from "../screens/students.screen.tsx";
import {CoursesScreen} from "../screens/courses.screen.tsx";
import {AddStaffScreen} from "../screens/add-staff.screen.tsx";
import {AddStudentScreen} from "../screens/add-student.screen.tsx";
import {SingleStudentScreen} from "../screens/single-student.screen.tsx";

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
                element: <Outlet />,
                children: [
                    {
                        path: "",
                        element: <StaffsScreen/>,
                    },
                    {
                        path: "add",
                        element: <AddStaffScreen/>,
                    },
                ]
            },
            {
                path: "/students",
                element: <Outlet />,
                children: [
                    {
                        path: "",
                        element: <StudentsScreen/>,
                    },
                    {
                        path: "add",
                        element: <AddStudentScreen/>,
                    },
                    {
                        path: ":id",
                        element: <SingleStudentScreen/>,
                    },
                ]
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