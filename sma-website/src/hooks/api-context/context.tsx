import {createContext} from "react";
import {CourseApi, StaffApi, StudentApi} from "@rtb";

interface ApiContext {
    staff: StaffApi;
    student: StudentApi;
    course: CourseApi;
}

export const apiContext = createContext<ApiContext>({} as ApiContext);



